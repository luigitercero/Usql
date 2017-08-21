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
public class Registro_Master extends Archivo {

    
    public FISQL.Almacenamiento.Master xml;

    public Registro_Master(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        xml = new FISQL.Almacenamiento.Master();
        try {
            getArchivo();
        } catch (Exception e) {
            System.out.println("No se pudo abrir Master");
        }
    }
    
    
    public void crearBaseDeDatos(String Nombre, String Path){
        try {
        escrbirAlFinal(xml.addBD(Nombre, Path), this.archivo);    
        } catch (Exception e) {
            System.out.println("no se pudo crear Base De Datos");
        }
        
    }
    
    
}
