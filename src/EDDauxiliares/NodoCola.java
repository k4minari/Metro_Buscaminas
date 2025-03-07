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
public class NodoCola {
    private Casilla casilla;
    private NodoCola siguiente;
    
    /**
     * Crea un nodo con la casilla asociada.
     * @param casilla Casilla a almacenar en este nodo.
     */
    public NodoCola(Casilla casilla) {
        this.casilla = casilla;
    }
    
    /** @return La casilla asociada a este nodo. */
    public Casilla getCasilla() { return casilla; }
    /** Asigna la casilla asociada a este nodo.
     * @param casilla */
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    /** @return El nodo siguiente en la cola. */
    public NodoCola getSiguiente() { return siguiente; }
    /** Asigna el nodo siguiente en la cola.
     * @param siguiente */
    public void setSiguiente(NodoCola siguiente) { this.siguiente = siguiente; }
}

