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
public class NodoHijo {
    NodoGeneral direccion;
    NodoHijo ant, sig;
    
    public NodoHijo(NodoGeneral puntero){
        direccion = puntero;
        ant = sig = null;
    }
}
