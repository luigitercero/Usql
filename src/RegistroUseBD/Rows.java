/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroUseBD;

/**
 *
 * @author luigitercero
 */
public class Rows {
    public String tipo;
    public String nombre;
    public boolean unique;
    public boolean fk;
    public boolean pk;

    public Rows(String tipo, String nombre, boolean unique, boolean fk, boolean pk) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.unique = unique;
        this.fk = fk;
        this.pk = pk;
    }
    
    
    public Rows(String tipo, String nombre){
        this.tipo = tipo;
        this.nombre = nombre;
        this.unique = false;
        this.fk = false;
        this.pk = false;
    
    }
}
