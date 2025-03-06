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
    
    public NodoCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    
    public Casilla getCasilla() { return casilla; }
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    public NodoCasilla getSiguiente() { return siguiente; }
    public void setSiguiente(NodoCasilla siguiente) { this.siguiente = siguiente; }
}
