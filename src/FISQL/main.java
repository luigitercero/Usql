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
import RegistroUseBD.Rows;
import RegistroUseBD.Tabla;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import java.io.StringReader;

/**
 *
 * @author luigitercero
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        // TODO code application logic here
        
        
        BufferedReader bf = new BufferedReader(new FileReader("BaseDedatos/Master.xml"));
        ej1 analizador = new ej1( bf) ;
        DBS dbs = new DBS(analizador.Inicio());
         
        dbs.useDB("prueba_uno");
        
       // System.out.println(dbs.getUseDB().DB.path);
        
        for (Tabla tabla : dbs.DB.rTabla) {
         //   System.out.println(tabla.nombre);
            for (Rows row : tabla.rows) {
           //     System.out.println("    "+ row.nombre);
            }
        }
        System.out.println("\u005ctAnalizador ha terminado.");
        
    }
}
