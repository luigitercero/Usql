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
public class Diccionario_XML {
    public String db(String nombre){return "<db>\n"+nombre+"</db>\n";}   
    public String nombre(String nombre){return "\t<nombre>"+nombre+"</nombre>\n";}   
    public String procedure(String procedure){return "<procedure>\n"+procedure+"</procedure>\n";}
    public String object(String object){return "<object>\n"+object+"</object>\n";}
    public String path(String path){return "\t<path>"+path+"</path>\n";}
    public String tabla(String contenido){return "<tabla>\n"+ contenido+"</tabla>\n";}
    public String rows(String row){return "\t<rows>\n"+row+"\t</rows>\n";}
    public String number(String _int){return "\t\t<int>"+_int+"</int>\n";}
    public String text(String text){return "\t\t<text>"+text+"</text>\n";}
    public String date(String text){return "\t\t<date>"+text+"</date>\n";}
    public String bool(String text){return "\t\t<bool>"+text+"</bool>\n";}
    public String row(String text){return "\t\t<row>"+text+"</row>\n";}
    public String nombreCampo(String text,int numCampo){return "<nombre_Campo"+numCampo+">"+text+"</nombre_Campo"+numCampo+">";}
    
      public String capo(String campo,String nombre){return "<"+nombre+">"+campo+"</"+nombre+">";}
    public String params(String params){return "<params>"+params+"</params>\n";}
    public String src(String src){return "\t\t<src>"+src+"</src>\n";}
    public String proc(String proc){return "<proc>\n"+proc+"</proc>\n";}
    public String obj(String obj){return "<obj>\n"+obj+"</obj>\n";}
    public String attr(String attr){return "\t<attr>\n"+attr+"t</attr>\n";}
    public String decimal(String decimal){return "\t\t<double>"+decimal+"</double>\n";}
    public String dateTime(String dateTime){return "\t\t<dateTime>"+dateTime+"</DateTime>\n";}
    
    public String tipo(String tipo,String nombre){
    switch(tipo.toLowerCase()){
        case "int":
            return number(nombre);
        case "text":
            return text(nombre);
        case "date":
            return date(nombre);
        case "bool":
            return bool(nombre);
        case "decimal":
            return decimal(nombre);
        case "datetime":
            return dateTime(nombre);
            
    }
    return "";
    }
    
    

    //public String proc(String proc){return "<proc>"+proc+"</proc>";}
    
    
    
}
