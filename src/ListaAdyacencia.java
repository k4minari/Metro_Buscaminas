/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Lista enlazada para almacenar las casillas adyacentes a una casilla dada.
 */
public class ListaAdyacencia {
    private NodoLista cabeza;

    /**
     * Constructor de la lista de adyacencia vacía.
     */
    public ListaAdyacencia() {
        this.cabeza = null;
    }

    /**
     * Agrega una casilla a la lista de adyacencia.
     * @param casilla Casilla a agregar.
     */
    public void agregar(Casilla casilla) {
        NodoLista nuevo = new NodoLista(casilla);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
}
