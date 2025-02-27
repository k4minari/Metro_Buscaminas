/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Representa una celda en el tablero de Buscaminas.
 */
public class Casilla {
    public int fila;
    public int columna;
    public boolean esMina;
    public boolean barrida;
    public ListaAdyacencia adyacentes;

    /**
     * Constructor de la casilla.
     * @param fila Fila donde se encuentra la casilla.
     * @param columna Columna donde se encuentra la casilla.
     */
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.esMina = false;
        this.barrida = false;
        this.adyacentes = new ListaAdyacencia();
    }
    
    public void Eskere(){
        System.out.println("Eskere");
    }
}

