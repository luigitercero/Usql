/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL;

import FISQL.Interprete.XML.Atributo;
import FISQL.Interprete.XML.Nodo;
import FISQL.Interprete.XML.ParseException;
import FISQL.Interprete.XML.ej1;
import RegistroUseBD.RegistroDB;
import RegistroUseBD.RegistroObjeto;
import RegistroUseBD.RegistroProcedure;
import RegistroUseBD.Rows;
import RegistroUseBD.Tabla;
import RegistroUseBD.Tipo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luigitercero
 */
public class DBS {

    public HashMap<String, Master> DBS = new HashMap<String, Master>();
    public RegistroDB DB;

    public DBS(FISQL.Interprete.XML.Nodo padre) {
        Master master;

        for (FISQL.Interprete.XML.Nodo db : padre.hijo) {
            master = new Master(db.hijo.get(0).hijo.get(0).nombre, db.hijo.get(1).hijo.get(0).nombre);
            DBS.put(master.nombre, master);
            //System.out.println("cargando a memoria " + master.nombre + " "+ master.path);
        }
        DB = new RegistroDB();
    }

    public void useDB(String nombre) throws FileNotFoundException, ParseException {
        DB.DB = DBS.get(nombre);
        if (DB.DB != null) {
            Nodo nodo;
            BufferedReader bf = new BufferedReader(new FileReader(DB.DB.path));
            ej1 analizador = new ej1(bf);
            nodo = analizador.Inicio();
            //nodo.recorrerHijos();
            cargarInformacionBD(nodo);

        }
    }

    public RegistroDB getUseDB() {
        return DB;
    }

    public void cargarInformacionBD(Nodo nodo) throws FileNotFoundException, ParseException {
      
        for (Nodo hijo : nodo.hijo) {

            switch (hijo.nombre) {
                case "tabla":
              
                    cargarInfoTabla(hijo);
                    break;
                case "object":
                    cargarObjetos(hijo);
                    break;
                case "procedure":
                    cargarProcedimiento(hijo);
                    break;
                default:
                    cargarInformacionBD(hijo);
            }
        }
    }

    private void cargarInfoTabla(Nodo nodo) {
        String nombre = null, path = null;
        ArrayList<Rows> row = null;
        

        for (Nodo hijo : nodo.hijo) {

            switch (hijo.nombre) {
                case "nombre":
                    //System.out.println("nombre de tabla " + hijo.hijo.get(0).nombre);                    
                    nombre = nombre(hijo);
                    break;
                case "path":
                    //System.out.println("nombre de path " + hijo.hijo.get(0).nombre);
                    path = hijo.hijo.get(0).nombre;
                    break;
                case "rows":
                    // System.out.println("Cargar encabezado");
                    row = cargarROWS(hijo);
                  

                    break;
                default:
                    cargarInfoTabla(hijo);
            }
        }
        DB.rTabla.add(new Tabla(nombre, path, row));
        
    }

    private ArrayList cargarROWS(Nodo nodo) {
        ArrayList<Rows> row = new ArrayList<>();
        for (Nodo hijo : nodo.hijo) {
            row.add(new Rows(hijo.nombre, nombre(hijo),hijo.atributo));
            //System.out.println("cargar tipo " + hijo.nombre);
        }
        return row;
    }

    private void cargarObjetos(Nodo hijo) throws FileNotFoundException, ParseException {
        Nodo nodo;
        BufferedReader bf = new BufferedReader(new FileReader(hijo.hijo.get(0).hijo.get(0).nombre));
        ej1 analizador = new ej1(bf);
        nodo = analizador.Inicio();
        //cargarObjeto(nodo);
        //nodo.recorrerHijos();

        for (Nodo nodo1 : nodo.hijo) {
            cargarObjeto(nodo1);
        }
        //cargarInformacionBD(nodo);
    }

    private void cargarObjeto(Nodo nodo) {
        String nombre = "";
      ArrayList<Tipo> atributo = null;
        for (Nodo nodo1 : nodo.hijo) {
            switch (nodo1.nombre) {
                case "nombre":
                    //System.out.println("esto es el nombre del objeto " + nodo1.hijo.get(0).nombre
                    nombre = nombre(nodo1);
                    break;
                case "attr":
                    atributo = cargarAtributo(nodo1);
                    break;
            }
        }
        RegistroObjeto ro = new RegistroObjeto(nombre, atributo);
        DB.OBJ.put(nombre, ro);
    }

    private ArrayList <Tipo> cargarAtributo(Nodo nodo) {

        ArrayList<Tipo> tipo = new ArrayList<>();
        for (Nodo nodo1 : nodo.hijo) {
            Tipo tip = new Tipo(nombre(nodo1), nodo1.nombre);
            tipo.add(tip);
        }
        return tipo;
    }

    private String nombre(Nodo nodo) {
        String nombre = "";
        for (Nodo nodo1 : nodo.hijo) {
            nombre = nombre + " " + nodo1.nombre;
        }
        return nombre;
    }

    public void MostrarDatosDB() {
        for (Tabla tabla : DB.rTabla) {
            System.out.println("tabla: " + tabla.nombre);
        }

        DB.OBJ.forEach((k, v) -> System.out.println("Objeto : " + k+"esqueleto objeto "+v.tipo.get(0) ));
        
        DB.Procedure.forEach((k, v) -> System.out.println("procedimiento : " + k+ "esqueleto de metodo "+v.metodo));

    }

    private void cargarProcedimiento(Nodo hijo) throws ParseException, FileNotFoundException {
        Nodo nodo;
        BufferedReader bf = new BufferedReader(new FileReader(hijo.hijo.get(0).hijo.get(0).nombre));
        ej1 analizador = new ej1(bf);
        nodo = analizador.Inicio();
        //nodo.recorrerHijos();

        for (Nodo nodo1 : nodo.hijo) {
            cargarProcedure(nodo1);
        }
    }

    private void cargarProcedure(Nodo nodo) {

        String nombre = "";
        ArrayList atributo = null;
        String metodo = "";
        for (Nodo nodo1 : nodo.hijo) {
            switch (nodo1.nombre) {
                case "nombre":
                    //System.out.println("esto es el nombre del objeto " + nodo1.hijo.get(0).nombre
                    nombre = nombre(nodo1);
                    break;
                case "params":
                    atributo = cargarParametros(nodo1);
                    break;
                case "src":
                    metodo= nombre(nodo1);
                    break;
            }
        }
        RegistroProcedure proc = new RegistroProcedure(nombre, atributo, metodo);
        DB.Procedure.put(nombre, proc);
    }

    private ArrayList cargarParametros(Nodo nodo) {
        ArrayList<Tipo> params = new ArrayList();
        for (Nodo nodo1 : nodo.hijo) {
            Tipo tip = new Tipo(nombre(nodo1), nodo1.nombre);
            params.add(tip);
        }
        return params;
    }

}
