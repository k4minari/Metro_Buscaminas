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
    
    public void agregar(Casilla casilla) {
        NodoLista nuevo = new NodoLista(casilla);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    public NodoLista getCabeza() { return cabeza; }
    public void setCabeza(NodoLista cabeza) { this.cabeza = cabeza; }
}
