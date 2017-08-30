/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL;

/**
 *
 * @author luigitercero
 */
public class Master {
    public String nombre;
    public String path;
    
    public Master(String nombre, String path){
        this.nombre = nombre;
        this.path  = "BaseDedatos/prueba_uno/"+nombre+ ".xml";
    }
}
