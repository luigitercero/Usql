/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL;

/**
 *
 * @author luigitercero
 */
public class GeneradoDeCompiladores {

    public static void main(String[] args) {
        // TODO code application logic here
        generarCompilador();
    }

    private static void generarCompilador() {
        try {
            String ruta = "src/FISQL/Interprete/Lenguaje/";
            String Exec="javacc " + ruta + "Lenguaje.jj ";
            Runtime.getRuntime().exec(Exec);
            Exec="mv *.java src/FISQL/Interprete/Lenguaje/";
            Runtime.getRuntime().exec(Exec);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
