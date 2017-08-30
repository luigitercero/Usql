/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroUseBD;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author luigitercero
 */
public class RegistroObjeto {
   public String nombre;

   public HashMap<String,Tipo> tipo;

    public RegistroObjeto(String nombre,  HashMap<String,Tipo>  tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

   
    
}
