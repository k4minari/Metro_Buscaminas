/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDDauxiliares;

import MetroInterfaz.CasillaUI;

/**
 *
 * @author cesar
 */
public class ListaCasillaUI {
    private NodoCasillaUI cabeza;
    
    /**
     * Constructor que inicia la lista vacía.
     */
    public ListaCasillaUI() {
        cabeza = null;
    }

    /**
     * Agrega un nuevo CasillaUI al final de la lista.
     * @param casillaUI Objeto CasillaUI a insertar.
     */
    public void agregar(CasillaUI casillaUI) {
        NodoCasillaUI nuevo = new NodoCasillaUI(casillaUI);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoCasillaUI actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    /**
     * Recorre la lista y actualiza cada CasillaUI (por ejemplo, refrescar su botón).
     */
    public void refrescar() {
        NodoCasillaUI actual = cabeza;
        while (actual != null) {
            actual.getCasillaUI().actualizarBoton();
            actual = actual.getSiguiente();
        }
    }
}