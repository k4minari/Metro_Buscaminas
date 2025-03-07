package EDDauxiliares;

import LogicaJuego.Casilla;

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
     * @param casilla Casilla a insertar.
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
     * Busca la casilla que coincide con la fila y la columna indicadas.
     * @param fila Fila a buscar.
     * @param columna Columna a buscar.
     * @return La casilla que coincide o null si no se encuentra.
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
    
    /** @return El nodo cabeza de la lista de casillas. */
    public NodoCasilla getCabeza() { return cabeza; }
    /** Asigna la cabeza de la lista de casillas.
     * @param cabeza */
    public void setCabeza(NodoCasilla cabeza) { this.cabeza = cabeza; }
}