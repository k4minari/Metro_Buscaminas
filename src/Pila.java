/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 */
public class Pila {
    private NodoPila tope;
    
    public void apilar(Casilla c) {
        NodoPila nuevo = new NodoPila(c);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }
    
    public Casilla desapilar() {
        if (tope == null) return null;
        Casilla c = tope.getCasilla();
        tope = tope.getSiguiente();
        return c;
    }
    
    public boolean estaVacia() {
        return (tope == null);
    }
}
