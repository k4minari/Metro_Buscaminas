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
    public Casilla casilla;
    public NodoLista siguiente;

    /**
     * Constructor del nodo.
     * @param casilla Referencia a la casilla que almacena este nodo.
     */
    public NodoLista(Casilla casilla) {
        this.casilla = casilla;
        this.siguiente = null;
    }
}
