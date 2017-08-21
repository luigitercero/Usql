/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento.DDL;

import java.io.File;

/**
 *
 * @author luigitercero
 */
public class DBMS extends Archivo{
     public File master;
    public DBMS(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        try {
            this.master = getArchivo();
        } catch (Exception e) {
           System.out.println("No se pudo abrir base de datos");
        }
        
    }
       
}
