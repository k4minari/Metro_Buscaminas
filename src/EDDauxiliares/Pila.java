package EDDauxiliares;


import LogicaJuego.Casilla;

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
    
    /**
     * Inserta (apila) una casilla en la parte superior.
     * @param c Casilla a apilar.
     */
    public void apilar(Casilla c) {
        NodoPila nuevo = new NodoPila(c);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }
    
    /**
     * Retira (desapila) la casilla en la parte superior.
     * @return Casilla en el tope, o null si la pila está vacía.
     */
    public Casilla desapilar() {
        if (tope == null) return null;
        Casilla c = tope.getCasilla();
        tope = tope.getSiguiente();
        return c;
    }
    
    /**
     * Verifica si la pila está vacía.
     * @return true si no hay elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return (tope == null);
    }
}