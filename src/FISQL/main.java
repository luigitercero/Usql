/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL;

import FISQL.Almacenamiento.DDL.*;
import FISQL.Almacenamiento.Encabezado;
import FISQL.Almacenamiento.Fila;

/**
 *
 * @author luigitercero
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Registro_Master m = new Registro_Master("Master", "BaseDedatos");
        m.crearBaseDeDatos("prueba_uno", "BaseDedatos/prueba_uno");
        Registro_DB db = new Registro_DB("prueba_uno", "BaseDedatos/prueba_uno");
        db.crearObjeto("objeto1", "BaseDedatos/prueba_uno/Objeto");
        Encabezado e[] = new Encabezado[2];
        e[1] = new Encabezado("edad", "int");
        e[0] = new Encabezado("nombre", "text");
        db.crearTabla("hombre", e, "BaseDedatos/prueba_uno/Tabla");
        Registro_Tabla tabla = new Registro_Tabla("hombre", "BaseDedatos/prueba_uno/Tabla");
        Fila f[] = new  Fila[2];
        f[0] = new Fila("Luis","nombre");
        f[1] = new Fila("25","edad");        
        tabla.crearFila(f);
    }
}
