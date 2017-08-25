/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Interprete.XML.Estructuras;

import java.nio.file.Path;

/**
 *
 * @author luigitercero
 */
public class NDB {
    public String nombre;
    public Path path;
   public NDB (String nombre, Path path){
       this.nombre = nombre;
       this.path =path;
   }
}
