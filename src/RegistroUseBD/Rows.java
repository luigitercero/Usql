/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroUseBD;

import FISQL.Interprete.XML.Atributo;
import java.util.ArrayList;

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
    public boolean auto;

    public Rows(String tipo, String nombre, boolean unique, boolean fk, boolean pk) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.unique = unique;
        this.fk = fk;
        this.pk = pk;
    }

    public Rows(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.unique = false;
        this.fk = false;
        this.pk = false;

    }

    public Rows(String nombre, String nombre0, ArrayList<Atributo> atributo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.unique = false;
        this.fk = false;
        this.pk = false;
        this.auto = false;

        for (Atributo atributo1 : atributo) {
            switch (atributo1.nombre) {
                case "pk":
                    if (atributo1.activado.equals("true")) pk = true;
                    break;
                case "fk":
                     if (atributo1.activado.equals("true")) fk = true;
                    break;
                case "u":
                    if (atributo1.activado.equals("true")) unique = true;
                    break;
                case "au":
                    if (atributo1.activado.equals("true")) auto = true;
                    break;
            }
        }
        

    }
}
