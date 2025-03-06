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
    private Casilla casilla;
    private NodoLista siguiente;
    
    public NodoLista(Casilla casilla) {
        this.casilla = casilla;
    }
    
    public Casilla getCasilla() { return casilla; }
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    public NodoLista getSiguiente() { return siguiente; }
    public void setSiguiente(NodoLista siguiente) { this.siguiente = siguiente; }
}
