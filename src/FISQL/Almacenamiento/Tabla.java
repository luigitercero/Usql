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
public class Tabla extends Diccionario_XML{
       
    private String nombre;
    private String path;
    private String rows;
    private int correlativo;
    
    public Tabla(String nombre, String path){
        this.nombre = nombre;
        this.path = path;
        this.rows = "";
        this.correlativo = 0;
    }

    public int getCorrelativo() {
        return correlativo;
    }
    
    
    public void addEncabezado(String tipo, String nombre){
       correlativo++;
       rows = rows+ tipo(tipo, nombre);
    }
    
    public String addTabla(){
        return tabla(nombre(this.nombre)+ path(this.path) + rows(this.rows));
    }
    
    
}
