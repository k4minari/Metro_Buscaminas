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
    
    public NodoCasilla getCabeza() { return cabeza; }
    public void setCabeza(NodoCasilla cabeza) { this.cabeza = cabeza; }
}
