package LogicaJuego;


import EDDauxiliares.ListaAdyacencia;

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
    private final int fila;
    private final int columna;
    private boolean tieneMina;
    private boolean barrida;
    private boolean marcada;
    private int minasAdyacentes;
    private ListaAdyacencia adyacentes;

    /**
     * Constructor que establece la posición de la Casilla (fila, columna).
     * @param fila    Fila en la que se ubica la casilla.
     * @param columna Columna en la que se ubica la casilla.
     */
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.tieneMina = false;
        this.barrida = false;
        this.marcada = false;
        this.minasAdyacentes = 0;
        this.adyacentes = new ListaAdyacencia();
    }
    
    // Getters y setters:
    public int getFila() { return fila; }
    public int getColumna() { return columna; }
    public boolean isTieneMina() { return tieneMina; }
    public void setTieneMina(boolean tieneMina) { this.tieneMina = tieneMina; }
    public boolean isBarrida() { return barrida; }
    public void setBarrida(boolean barrida) { this.barrida = barrida; }
    public boolean isMarcada() { return marcada; }
    public void setMarcada(boolean marcada) { this.marcada = marcada; }
    public int getMinasAdyacentes() { return minasAdyacentes; }
    public void setMinasAdyacentes(int minasAdyacentes) { this.minasAdyacentes = minasAdyacentes; } 
    public ListaAdyacencia getAdyacentes() { return adyacentes; }
    public void setAdyacentes(ListaAdyacencia adyacentes) { this.adyacentes = adyacentes; }
    
    /**
     * Genera un identificador textual para la casilla, 
     * usando la columna convertida en letra (A, B, C...) y la fila + 1.
     * @return Una cadena tipo "A1", "B2", etc.
     */
    public String getID() {
        char letra = (char)('A' + columna);
        int numero = fila + 1;
        return "" + letra + numero;
    }
}