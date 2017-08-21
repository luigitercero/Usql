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
public class Obj extends Diccionario_XML{
        private String parametros;
    private String nombre;
    private String instrucciones;
   
    public Obj(String nombre) {
        this.nombre = nombre;
        this.parametros = "";
        this.instrucciones = "";
    }

    public void addAtributo(String tipo, String nombre) {
        parametros =  parametros + tipo(tipo, nombre);
    }
    

    public String addObj(){
        return proc(nombre(nombre)+ attr(parametros));
    
    }
    
}
