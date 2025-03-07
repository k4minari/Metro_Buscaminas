package EDDauxiliares;

import LogicaJuego.Casilla;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Representa un nodo en la lista de adyacencia de una casilla.
 */
public class NodoLista {
    private Casilla casilla;
    private NodoLista siguiente;
    
    /**
     * Crea un nodo que almacena la casilla dada.
     * @param casilla Casilla que se guardará en este nodo.
     */
    public NodoLista(Casilla casilla) {
        this.casilla = casilla;
    }
    
    /** @return La casilla asociada a este nodo. */
    public Casilla getCasilla() { return casilla; }
    /** Asigna la casilla asociada a este nodo.
     * @param casilla */
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    /** @return El nodo siguiente en la lista de adyacencia. */
    public NodoLista getSiguiente() { return siguiente; }
    /** Asigna el siguiente nodo.
     * @param siguiente */
    public void setSiguiente(NodoLista siguiente) { this.siguiente = siguiente; }
}
