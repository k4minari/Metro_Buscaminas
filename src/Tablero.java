/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cesar
 * Representa el tablero de Buscaminas.
 */
/**
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
     * Crea las casillas del tablero y las almacena en la lista.
     * Se recorre de forma que la primera casilla generada (A1) quede en la esquina superior izquierda.
     */
    private void inicializarCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Se asume que la clase Casilla tiene un constructor que recibe fila y columna.
                Casilla c = new Casilla(i, j);
                lista.agregar(c);
            }
        }
    }

    /**
     * Imprime en consola una representación textual del tablero.
     * Cada casilla se muestra con su identificador (por ejemplo, A1, B1, …).
     */
    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Se asume que ListaCasillas tiene el método buscar(fila, columna)
                Casilla c = lista.buscar(i, j);
                if (c != null) {
                    System.out.print(c.getID() + "\t");
                } else {
                    System.out.print("----\t");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Representación en cadena del tablero.
     * @return Una cadena que contiene el tablero en formato de matriz.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla c = lista.buscar(i, j);
                sb.append(c.getID() + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

