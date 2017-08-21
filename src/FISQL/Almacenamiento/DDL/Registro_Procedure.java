/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento.DDL;

import FISQL.Almacenamiento.Encabezado;
import FISQL.Almacenamiento.Procedure;


/**
 *
 * @author luigitercero
 */
public class Registro_Procedure extends Archivo {

    public FISQL.Almacenamiento.Procedure xml;

    public Registro_Procedure(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        xml = new FISQL.Almacenamiento.Procedure(nombre);
        try {
            getArchivo();
            System.out.println("Se trabajara con la base de datos " + nombre);
        } catch (Exception e) {
            System.out.println("No se pudo abrir Registro de la base de datos " + nombre);
        }
    }

    public void crearparametro(String nombre, Encabezado encabezado[], String instrucciones) {
        Procedure t = new Procedure(nombre);
        for (Encabezado encabezado1 : encabezado) {
            t.addParametros(encabezado1.Tipo, encabezado1.Nombre);
        }
        t.addIntrucciones(instrucciones);

        try {
            escrbirAlFinal(t.addProcedure(), archivo);
        } catch (Exception e) {
            System.out.println("no se pudo crear la fila");
        }
    }
}
