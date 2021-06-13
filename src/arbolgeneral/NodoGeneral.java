/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgeneral;

/**
 *
 * @author luisa
 */
public class NodoGeneral {
    char dato;
    NodoHijo ini, fin;
    
    public NodoGeneral(char dato){
        this.dato = dato;
        ini = fin = null;
    }
    
    public boolean enlazar(NodoGeneral hijo){
        NodoHijo enlace = new NodoHijo(hijo);
        if(enlace == null)return false;
        if(esHoja()){
            ini = fin = enlace;
            return true;
        }
        fin.sig = enlace;
        enlace.ant = fin;
        fin = enlace;
        return true;
    }
    
    public boolean esHoja(){
        return ini == null && fin == null;
    }
    
    public NodoGeneral obtenerHijo(char valor){
        if(esHoja())return null;
        for(NodoHijo b = ini; b != null; b = b.sig)
            if(b.direccion.dato == valor)return b.direccion;
        return null;
    }

    boolean desenlazar(NodoGeneral hijo) {
        if(ini == fin){
            if(fin.direccion == hijo){
                ini = fin = null;
                return true;
            }
            return false;
        }
        NodoHijo t = ini;
        if(ini.direccion == hijo){
            ini = t.sig;
            ini.ant = t.sig = t = null;
            return true;
        }
        
        if(fin.direccion == hijo){
            t = fin;
            fin = t.ant;
            fin.sig = t.ant = t = null;
            return true;
        }
        
        t = t.sig;
        while(t.direccion == hijo && t != null){
            t = t.sig;
        }
        if(t == null)return false;
        t.sig.ant = t.ant;
        t.ant.sig = t.sig;
        t.sig = t.ant = t = null;
        return true;
    }
}
