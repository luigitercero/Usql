/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento.DDL;

import FISQL.Almacenamiento.Tabla;
import FISQL.Almacenamiento.Encabezado;

/**
 *
 * @author luigitercero
 */
public class Registro_DB extends Archivo {

    public FISQL.Almacenamiento.DB xml;

    public Registro_DB(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        xml = new FISQL.Almacenamiento.DB();
        try {
            getArchivo();
            System.out.println("Se trabajara con la base de datos " + nombre);
        } catch (Exception e) {
            System.out.println("No se pudo abrir Registro de la base de datos " + nombre);
        }
    }

    public void crearProcedimiento(String Nombre, String path) {
        try {
            escrbirAlFinal(xml.addProcedures(path), archivo);
        } catch (Exception e) {
            System.out.println("no se pudo crear procedimento");
        }
    }

    public void crearObjeto(String nombre, String Path) {

        try {
            escrbirAlFinal(xml.addObjects(Path), archivo);
        } catch (Exception e) {
            System.out.println("no se pudo crear Objecto");
        }
    }

    public void crearTabla(String nombre, Encabezado encabezado[], String path) {
        Tabla t = new Tabla(nombre, path);
        for (Encabezado encabezado1 : encabezado) {
            t.addEncabezado(encabezado1.Tipo, encabezado1.Nombre);
        }
        try {
            escrbirAlFinal(xml.addTablas(t.addTabla()), archivo);
        } catch (Exception e) {
            System.out.println("no se pudo crear tabla");
        }
    }

}
