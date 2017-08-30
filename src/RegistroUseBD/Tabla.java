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
public class Tabla {

    public String nombre;
    public String path;
    public ArrayList<Rows> rows;

    public Tabla(String nombre, String path, ArrayList rows) {
        this.nombre = nombre;
        this.path = path;
        this.rows = rows;
    }
    public Tabla() {
  
    }
}
