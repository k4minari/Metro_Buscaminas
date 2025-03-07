/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDDauxiliares;

import MetroInterfaz.CasillaUI;

/**
 *
 * @author cesar
 */
public class NodoCasillaUI {
    private CasillaUI casillaUI;
    private NodoCasillaUI siguiente;
    
    /**
     * Constructor que recibe la CasillaUI asociada a este nodo.
     * @param casillaUI Objeto CasillaUI que se almacenará en este nodo.
     */
    public NodoCasillaUI(CasillaUI casillaUI) {
        this.casillaUI = casillaUI;
        this.siguiente = null;
    }

    /** @return La CasillaUI almacenada en este nodo. */
    public CasillaUI getCasillaUI() { 
        return casillaUI; 
    }
    /** Asigna la CasillaUI en este nodo.
     * @param casillaUI */
    public void setCasillaUI(CasillaUI casillaUI) { 
        this.casillaUI = casillaUI; 
    }

    /** @return El nodo siguiente en la lista. */
    public NodoCasillaUI getSiguiente() { 
        return siguiente; 
    }
    /** Asigna el siguiente nodo de la lista.
     * @param siguiente */
    public void setSiguiente(NodoCasillaUI siguiente) { 
        this.siguiente = siguiente; 
    }
}