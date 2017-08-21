/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento;

/**
 *
 * @author luigitercero
 */
public class DB extends Diccionario_XML {

    private String procedure;
    private String object;
    private String tabla;

    public DB() {
        this.procedure = "";
        this.object = "";
        this.tabla = "";
    }

    public void addProcedure(String Ubicacion) {
        procedure = procedure + procedure(path(Ubicacion));
    }

    public void addObject(String Ubicacion) {
        object = object + object(Ubicacion);
    }

    public void addTabla(String tabla) {
        this.tabla = this.tabla + tabla;
    }

    public String addProcedures(String Ubicacion) {
        return procedure(path(Ubicacion));
    }

    public String addObjects(String Ubicacion) {
        return object(path(Ubicacion));
    }

    public String addTablas(String tabla) {
        return tabla;
    }

}
