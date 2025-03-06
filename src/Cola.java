/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 */
public class Cola {
    private NodoCola frente;
    private NodoCola fin;
    
    public void encolar(Casilla c) {
        NodoCola nuevo = new NodoCola(c);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        if (frente == null) {
            frente = fin;
        }
    }
    
    public Casilla desencolar() {
        if (frente == null) return null;
        Casilla c = frente.getCasilla();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return c;
    }
    
    public boolean estaVacia() {
        return (frente == null);
    }
}
