/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Representa el tablero de Buscaminas.
 */
public class Tablero {
    private int filas;
    private int columnas;
    private ListaCasillas lista;

    /**
     * Constructor del tablero.
     * @param filas Número de filas del tablero.
     * @param columnas Número de columnas del tablero.
     */
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.lista = new ListaCasillas();
        inicializarCasillas();
    }

    /**
     * Crea las casillas del tablero y las almacena en la lista de casillas.
     */
    private void inicializarCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla c = new Casilla(i, j);
                lista.agregar(c);
            }
        }
    }
}
