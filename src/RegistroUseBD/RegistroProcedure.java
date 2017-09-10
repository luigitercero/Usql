/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroUseBD;

import java.util.ArrayList;

/**
 *
 * @author luigitercero
 */
public class RegistroProcedure {
    public String nombre;
    public ArrayList parametro;
    public String metodo;

    public RegistroProcedure(String nombre, ArrayList parametro, String metodo) {
        this.nombre = nombre;
        this.parametro = parametro;
        this.metodo = metodo;
    }
    
    
}
