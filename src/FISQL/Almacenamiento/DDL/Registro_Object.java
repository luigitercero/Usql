/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento.DDL;
import FISQL.Almacenamiento.Encabezado;
import FISQL.Almacenamiento.Obj;
/**
 *
 * @author luigitercero
 */
public class Registro_Object extends Archivo{
        public FISQL.Almacenamiento.Procedure xml;

    public Registro_Object(String nombre, String ubicacion) {
        super(nombre, ubicacion);
     //   xml = new FISQL.Almacenamiento.Obj(nombre);
        try {
            getArchivo();
            System.out.println("Se trabajara con la base de datos " + nombre);
        } catch (Exception e) {
            System.out.println("No se pudo abrir Registro de la base de datos " + nombre);
        }
    }

    public void crearparametro(String nombre, Encabezado encabezado[], String instrucciones) {
        Obj t = new Obj(nombre);
        for (Encabezado encabezado1 : encabezado) {
            t.addAtributo(encabezado1.Tipo, encabezado1.Nombre);
        }
        

        try {
            escrbirAlFinal(t.addObj(), archivo);
        } catch (Exception e) {
            System.out.println("no se pudo crear la fila");
        }
    }
}
