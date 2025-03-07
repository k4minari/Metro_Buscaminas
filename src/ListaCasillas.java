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
     * Agrega una casilla al final de la lista.
     * Esto asegura que la primera casilla generada (por ejemplo, A1)
     * quede en la cabeza de la lista.
     * @param casilla La casilla a agregar.
     */
    public void agregar(Casilla casilla) {
        NodoCasilla nuevo = new NodoCasilla(casilla);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCasilla actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    /**
     * Busca y devuelve la casilla que se encuentra en la fila y columna indicadas.
     * @param fila La fila (0-indexado).
     * @param columna La columna (0-indexado).
     * @return La casilla si se encuentra, o null en caso contrario.
     */
    public Casilla buscar(int fila, int columna) {
        NodoCasilla actual = cabeza;
        while (actual != null) {
            Casilla c = actual.getCasilla();
            if (c.getFila() == fila && c.getColumna() == columna) {
                return c;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
}