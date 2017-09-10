/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroUseBD;

import FISQL.Master;
import RegistroUseBD.Tabla;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author luigitercero
 */
public class RegistroDB {

    public RegistroDB(Master DB) {
        this.DB = DB;
        this.rTabla = new ArrayList<>();
    }
    
      public RegistroDB() {
        this.DB = null;
        this.rTabla = new ArrayList<>();
        this.OBJ = new HashMap<>();
        this.Procedure = new HashMap<>();
      }
    public Master DB;
    public ArrayList<Tabla> rTabla;
    public HashMap<String,RegistroObjeto> OBJ;
    public HashMap<String,RegistroProcedure> Procedure;
    
    
}
