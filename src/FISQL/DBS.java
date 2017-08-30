/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL;

import FISQL.Interprete.XML.Nodo;
import FISQL.Interprete.XML.ParseException;
import FISQL.Interprete.XML.ej1;
import RegistroUseBD.RegistroDB;
import RegistroUseBD.RegistroObjeto;
import RegistroUseBD.Rows;
import RegistroUseBD.Tabla;
import RegistroUseBD.Tipo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

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
                    nombre = hijo.hijo.get(0).nombre;
                    break;
                case "path":
                    //System.out.println("nombre de path " + hijo.hijo.get(0).nombre);
                    path = hijo.hijo.get(0).nombre;
                    break;

                case "rows":
                   // System.out.println("Cargar encabezado");
                    row = cargarROWS(hijo);
//                    /System.out.println("cargar encabezado");
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
            row.add(new Rows(hijo.nombre, hijo.hijo.get(0).nombre));
            //System.out.println("cargar tipo " + hijo.nombre);

        }
        return row;

    }

    private void cargarObjetos(Nodo hijo) throws FileNotFoundException, ParseException {
        Nodo nodo;
        BufferedReader bf = new BufferedReader(new FileReader(hijo.hijo.get(0).hijo.get(0).nombre));
        ej1 analizador = new ej1(bf);
        nodo = analizador.Inicio();
        cargarObjeto(nodo);
        //nodo.recorrerHijos();
        for (Nodo nodo1 : nodo.hijo) {
            cargarObjeto(nodo1);

        }
        //cargarInformacionBD(nodo);

    }

    private void cargarObjeto(Nodo nodo) {

        String nombre = null;
        HashMap<String, Tipo> atributo = null;
        for (Nodo nodo1 : nodo.hijo) {
            switch (nodo1.nombre) {
                case "nombre":
                    //System.out.println("esto es el nombre del objeto " + nodo1.hijo.get(0).nombre);
                    nombre = nodo1.hijo.get(0).nombre;
                    break;
                case "attr":
                    atributo = cargarAtributo(nodo1);
                    break;
            }
        }
        RegistroObjeto ro = new RegistroObjeto(nombre, atributo);
        DB.OBJ.put(nombre, ro);

    }

    private HashMap<String, Tipo> cargarAtributo(Nodo nodo) {

        HashMap<String, Tipo> tipo = new HashMap<>();
        for (Nodo nodo1 : nodo.hijo) {
            Tipo tip = new Tipo(nodo1.hijo.get(0).nombre, nodo1.nombre);
            tipo.put(nodo1.hijo.get(0).nombre, tip);
        }
        return tipo;
    }

}
