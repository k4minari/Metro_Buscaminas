/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 */
public class NodoPila {
    private Casilla casilla;
    private NodoPila siguiente;
    
    public NodoPila(Casilla casilla) {
        this.casilla = casilla;
    }
    
    public Casilla getCasilla() { return casilla; }
    public void setCasilla(Casilla casilla) { this.casilla = casilla; }
    
    public NodoPila getSiguiente() { return siguiente; }
    public void setSiguiente(NodoPila siguiente) { this.siguiente = siguiente; }
}

