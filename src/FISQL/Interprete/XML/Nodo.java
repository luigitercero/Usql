/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FISQL.Interprete.XML;


import java.util.ArrayList;

/**
 *
 * @author luigitercero
 */
public class Nodo {
    public ArrayList <Nodo> hijo ;
    public String nombre;
    public Token token;
    
   public Nodo(String nombre){
       this.nombre = nombre;
       this.hijo = new ArrayList<Nodo>();
       this.token = null;
   }
   
   public Nodo(String nombre, Token token){
       this.nombre = nombre;
       this.hijo = new ArrayList<Nodo>();
       this.token = token;
   }
   
   private void recorrerHijos(String tab){
       System.out.println(tab + nombre);
       for (Nodo nodo : hijo) {    
           nodo.recorrerHijos(tab + "   ");
       }
       
   }
   
      public void recorrerHijos(){
       System.out.println(nombre);
       for (Nodo nodo : hijo) {    
           nodo.recorrerHijos("   ");
       }
       
   }
   
   
}
