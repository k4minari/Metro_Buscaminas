/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 */
public class NodoCola {
    private Casilla casilla;
    private NodoCola siguiente;
    
    public NodoCola(Casilla casilla) {
        this.casilla = casilla;
    }
    
    public Casilla getCasilla() { return casilla; }
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    public NodoCola getSiguiente() { return siguiente; }
    public void setSiguiente(NodoCola siguiente) { this.siguiente = siguiente; }
}

