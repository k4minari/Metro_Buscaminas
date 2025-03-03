/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Representa una celda en el tablero de Buscaminas.**/
public class Casilla {
    // Atributos privados
    private int fila;
    private int columna;
    
    /**
     * Constructor que recibe la fila y columna de la casilla.
     * @param fila La fila (0-indexado).
     * @param columna La columna (0-indexado).
     */
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    /**
     * Devuelve la fila de la casilla.
     * @return La fila.
     */
    public int getFila() {
        return fila;
    }
    
    /**
     * Devuelve la columna de la casilla.
     * @return La columna.
     */
    public int getColumna() {
        return columna;
    }
    
    /**
     * Genera un identificador en formato "A1", donde A es la columna (0 → A, 1 → B, etc.)
     * y 1 corresponde a la fila 0.
     * @return El identificador de la casilla.
     */
    public String getID() {
        char letra = (char)('A' + columna);
        int numero = fila + 1;
        return "" + letra + numero;
    }
}

