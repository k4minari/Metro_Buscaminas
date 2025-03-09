/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaJuego;

import MetroInterfaz.TableroUI;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class Juego {
    /** Tablero que representa la lógica del juego. */
    private Tablero tablero;
    
    /** Interfaz gráfica que muestra el tablero en pantalla. */
    private TableroUI tableroUI;
    
    /** Puntaje final del juego, calculado al terminar. */
    private double puntaje;
    
    /** Indica si se ha ganado (true) o no (false). */
    private boolean ganado;
    
    /**
     * Constructor vacío: no inicia nada hasta que llamemos a iniciarPartida().
     */
    public Juego() {
        this.tablero = null;
        this.tableroUI = null;
        this.puntaje = 0.0;
        this.ganado = false;
    }
    
    /**
     * Crea un tablero nuevo y su interfaz.
     * @param filas    Número de filas del tablero.
     * @param columnas Número de columnas del tablero.
     * @param numMinas Número de minas a colocar en el tablero.
     */
    public void iniciarJuegoNuevo(int filas, int columnas, int numMinas) {
        this.tablero = new Tablero(filas, columnas, numMinas);
        this.tableroUI = new TableroUI(tablero);
        this.puntaje = 0.0;
        this.ganado = false;
    }
    
    /**
     * Carga un tablero desde un archivo CSV y crea la interfaz. 
     * Internamente pregunta con un JFileChooser la ubicación del CSV.
     * Si la carga falla o el usuario cancela, crea un tablero por defecto.
     */
    public void cargarJuego() {
        try {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Cargar partida desde CSV");

            int userSelection = fc.showOpenDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File archive = fc.getSelectedFile();
                try {
                    // Asigna "this.tablero" al tablero cargado
                    this.tablero = Tablero.fromCSV(archive);
                    // Crea la interfaz con "this.tablero"
                    this.tableroUI = new TableroUI(this.tablero);
                    this.puntaje = 0.0;
                    this.ganado = this.tablero.isGameOver();
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cargar el archivo CSV");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Si hay excepción inesperada, se crea un tablero por defecto
            this.tablero = new Tablero(8, 8, 5);
            this.tableroUI = new TableroUI(this.tablero);
            this.puntaje = 0.0;
            this.ganado = this.tablero.isGameOver();
        }
    }

    /**
     * Calcula el puntaje al finalizar la partida, basado en:
     * - filas x columnas x 100
     * - numMinas
     * - tiempoFinal
     * 
     * Muestra el puntaje y si se ganó en un JOptionPane.
     * 
     * @param tiempoFinal Segundos que duró la partida (ejemplo: TableroUI lleva la cuenta).
     */
    public void calcularPuntaje(int tiempoFinal) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        int minas = tablero.getNumMinas();
        int time = (tiempoFinal <= 0) ? 1 : tiempoFinal;
        double base = filas * columnas * 100.0;
        this.puntaje = base / (minas * time);
        
        // Determinamos si se ganó
        this.ganado = tablero.isGameOver(); 
        JOptionPane.showMessageDialog(null, 
            "Puntaje final: " + puntaje + "\nGanado: " + ganado);
    }
    
    /** @return El puntaje final calculado. */
    public double getPuntaje() {
        return puntaje;
    }
    
    /** @return true si se ganó, false en caso contrario. */
    public boolean isGanado() {
        return ganado;
    }
    
    /** @return El objeto Tablero actual (lógica). */
    public Tablero getTablero() {
        return tablero;
    }
    
    /** @return El objeto TableroUI (interfaz). */
    public TableroUI getTableroUI() {
        return tableroUI;
    }
}

