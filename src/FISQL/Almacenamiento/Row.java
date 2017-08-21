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
public class Row extends Diccionario_XML {

    private int correlativo;
    private String row;

    public Row() {
        this.correlativo = 0;
        this.row = "";
    }

    public void addNuevoCampo(String campo,String nombre) {
        correlativo++;
        this.row = this.row +capo(nombre, campo);
    }
    
    public String addrRow(){
    return row(this.row);
    
    }
   
}
