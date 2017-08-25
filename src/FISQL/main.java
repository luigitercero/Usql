/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL;

import FISQL.Almacenamiento.DDL.*;
import FISQL.Almacenamiento.Encabezado;
import FISQL.Almacenamiento.Fila;
import FISQL.Interprete.XML.ParseException;
import FISQL.Interprete.XML.ej1;


import java.io.StringReader;

/**
 *
 * @author luigitercero
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        ej1 analizador = new ej1( new StringReader("<db>hola</db>"+
                "<db><nombre>segunda Base De Datos</nombre> <path>segunda_base_Datos</path></db>")) ;
        analizador.Inicio().recorrerHijos();
        System.out.println("\u005ctAnalizador ha terminado.");
        
    }
}
