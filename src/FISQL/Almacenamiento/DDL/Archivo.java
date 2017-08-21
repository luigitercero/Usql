/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Almacenamiento.DDL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author luigitercero
 */
public class Archivo {

    public File archivo;
    protected String Nombre;
    protected String Ubicacion;

    public Archivo(String nombre, String ubicacion) {
        this.Nombre = nombre;
        this.Ubicacion = ubicacion;
    }

    public Archivo(String nombre) {
        this.Nombre = nombre;
        this.Ubicacion = "Archivo";
    }

    public File getArchivo() throws IOException {
        // File archivo = new File(/*Ubicacion+"/"+*/Nombre + ".xml");
        File directorio = new File(Ubicacion);
        directorio.mkdirs();
        File archivo = new File(Ubicacion + "/" + Nombre + ".xml");
        BufferedWriter bw;
        if (archivo.exists()) {
            this.archivo = archivo;
            return archivo;
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.close();
            this.archivo = archivo;
            return archivo;
        }

    }

    public void escrbirAlFinal(String contenido, File archivo) throws IOException {
        FileWriter w = new FileWriter(archivo, true);
        w.write(contenido);
        w.close();

    }

}
