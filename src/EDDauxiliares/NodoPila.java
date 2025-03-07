package EDDauxiliares;

import LogicaJuego.Casilla;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 */
public class NodoPila {
    private Casilla casilla;
    private NodoPila siguiente;
    
    /**
     * Constructor que asocia la casilla a este nodo de la pila.
     * @param casilla Casilla a almacenar.
     */
    public NodoPila(Casilla casilla) {
        this.casilla = casilla;
    }
    
    /** @return La casilla asociada a este nodo. */
    public Casilla getCasilla() { return casilla; }
    /** Asigna la casilla asociada a este nodo.
     * @param casilla */
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    /** @return El siguiente nodo en la pila. */
    public NodoPila getSiguiente() { return siguiente; }
    /** Asigna el siguiente nodo de la pila.
     * @param siguiente */
    public void setSiguiente(NodoPila siguiente) { this.siguiente = siguiente; }
}

