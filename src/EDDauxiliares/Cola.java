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
public class Cola {
    private NodoCola frente;
    private NodoCola fin;
    
    /**
     * Encola (inserta al final) una casilla.
     * @param c Casilla a encolar.
     */
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
    
    /**
     * Desencola (retira del frente) y retorna la casilla.
     * @return Casilla que estaba en el frente, o null si la cola está vacía.
     */
    public Casilla desencolar() {
        if (frente == null) return null;
        Casilla c = frente.getCasilla();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return c;
    }
    
    /**
     * Verifica si la cola está vacía.
     * @return true si no hay elementos en la cola, false en caso contrario.
     */
    public boolean estaVacia() {
        return (frente == null);
    }
}
