/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Lista enlazada para almacenar todas las casillas del tablero.
 */
public class ListaCasillas {
    private NodoCasilla cabeza;

    /**
     * Constructor de la lista de casillas vacía.
     */
    public ListaCasillas() {
        this.cabeza = null;
    }

    /**
     * Agrega una casilla a la lista de casillas.
     * @param casilla Casilla a agregar.
     */
    public void agregar(Casilla casilla) {
        NodoCasilla nuevo = new NodoCasilla(casilla);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
}
