/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento;

/**
 *
 * @author luigitercero
 */
public class Master extends Diccionario_XML{
    
    public String addBD(String Nombre, String Path) {
        return db(nombre(Nombre)+path(Path));
    }
    
    

}
