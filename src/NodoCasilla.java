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
     * Constructor del nodo, que recibe una casilla.
     * @param casilla La casilla a almacenar.
     */
    public NodoCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    
    /**
     * Devuelve la casilla almacenada.
     * @return La casilla.
     */
    public Casilla getCasilla() {
        return casilla;
    }
    
    /**
     * Devuelve el siguiente nodo en la lista.
     * @return El siguiente nodo.
     */
    public NodoCasilla getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el siguiente nodo en la lista.
     * @param siguiente El nodo que seguirá.
     */
    public void setSiguiente(NodoCasilla siguiente) {
        this.siguiente = siguiente;
    }
}
