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
public class Procedure extends Diccionario_XML {

    private String parametros;
    private String nombre;
    private String instrucciones;
   
    public Procedure(String nombre) {
        this.nombre = nombre;
        this.parametros = "";
        this.instrucciones = "";
    }

    public void addParametros(String tipo, String nombre) {
        parametros =  parametros + tipo(tipo, nombre);
    }
    
    public void addIntrucciones(String instrucciones){
        this.instrucciones = instrucciones;        
    }
    
    public String addProcedure(){
        return proc(nombre(nombre)+ params(parametros)+src(instrucciones));
    
    }
    
}
