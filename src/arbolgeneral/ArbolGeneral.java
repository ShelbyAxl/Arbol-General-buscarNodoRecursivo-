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
public class ArbolGeneral {
    NodoGeneral raiz;
    
    public ArbolGeneral(){
        raiz = null;
    }
    
    public boolean insertar(char dato, String path){
        if(raiz == null){
            raiz = new NodoGeneral(dato);
            if(raiz == null)return false;
            return true;
        }
        if(path.isEmpty()) return false;
        NodoGeneral padre = buscarNodo(path);
        if(padre == null)return false;
        NodoGeneral exist = buscarNodo(path + "/" + dato);
        if(exist != null)return false;
        NodoGeneral n = new NodoGeneral(dato);
        return padre.enlazar(n);
    }
    
    public boolean eliminar(String path){
        if(raiz == null)return false;
        NodoGeneral hijo = buscarNodo(path);
        if(hijo == null)return false;
        if(!hijo.esHoja())return false;
        if(hijo == raiz){
            raiz = null;
            return true;
        }
        String pathF = obtenerPathPadre(path);
        NodoGeneral  padre = buscarNodo(path);
        
        return padre.desenlazar(hijo);
    }

    private NodoGeneral buscarNodo(String path) {
        path = path.substring(1);
        String vector[] = path.split("/");
        if(vector[0].charAt(0) == raiz.dato){
            if(vector.length == 1)return raiz;
            
            NodoGeneral padre = raiz;
            for(int i=1; i < vector.length; i++){
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre == null)return null;
            }
            return padre;
        }
        return null;
    }
    
    private NodoGeneral buscarNodoRecursivo(String path, int cont){ //CUANDO SE MANDE A LLAMAR ESTA FUNCION ES NECESARIO PONER 0 EN EL PARAMETRO DE CONT
        if(cont == path.split("/").length-1)return raiz;
        if(cont == 0)path = path.substring(1);
        if(path.split("/")[0].charAt(0) == raiz.dato){
            if(path.split("/").length == 1)return raiz;
        }
        if(raiz.obtenerHijo(path.split("/")[cont].charAt(0)) != null)return buscarNodoRecursivo(path, cont+1);
        return null;
    }

    private String obtenerPathPadre(String path) {
        int posicionUltDiag = path.lastIndexOf("/")-1;
        return path.substring(0, posicionUltDiag);
    }
}
