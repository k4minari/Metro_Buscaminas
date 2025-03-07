package EDDauxiliares;

import LogicaJuego.Casilla;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Representa un nodo en la lista de casillas del tablero.
 */
public class NodoCasilla {
    private Casilla casilla;
    private NodoCasilla siguiente;
    
    /**
     * Crea un nodo que almacena la casilla dada.
     * @param casilla Casilla que se guardará en este nodo.
     */
    public NodoCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    
    /** @return La casilla asociada a este nodo. */
    public Casilla getCasilla() { return casilla; }
    /** Asigna la casilla asociada a este nodo.
     * @param casilla */
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    /** @return El siguiente nodo de la lista de casillas. */
    public NodoCasilla getSiguiente() { return siguiente; }
    /** Asigna el siguiente nodo de la lista.
     * @param siguiente */
    public void setSiguiente(NodoCasilla siguiente) { this.siguiente = siguiente; }
}