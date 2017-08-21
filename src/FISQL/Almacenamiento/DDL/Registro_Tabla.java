package FISQL.Almacenamiento.DDL;
import FISQL.Almacenamiento.Fila;
import FISQL.Almacenamiento.DDL.Archivo;
import FISQL.Almacenamiento.Row;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author luigitercero
 */
public class Registro_Tabla extends Archivo{
        public FISQL.Almacenamiento.Row xml;

    public Registro_Tabla(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        xml = new FISQL.Almacenamiento.Row();
        try {
            getArchivo();
            System.out.println("Se trabajara con la base de datos " + nombre);
        } catch (Exception e) {
            System.out.println("No se pudo abrir Registro de la base de datos " + nombre);
        }
    }

    public void crearFila(Fila fila[]) {
         Row t = new Row();
        for (Fila campo1 : fila) {
            t.addNuevoCampo(campo1.campo, campo1.nombre);
        }
        try {
            escrbirAlFinal(t.addrRow(),archivo);
        } catch (Exception e) {
            System.out.println("no se pudo crear la fila");
        }
    }
}
