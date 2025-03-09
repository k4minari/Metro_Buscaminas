/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaJuego;

import MetroInterfaz.Start;
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
    
    /**
     * Constructor vacío.
     */
    public Juego() {
        this.tablero = null;
        this.tableroUI = null;
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
                    this.tablero = Tablero.cargarCSV(archive);
                    // Crea la interfaz con "this.tablero"
                    this.tableroUI = new TableroUI(this.tablero);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cargar el archivo CSV");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                Start menu = new Start();
                menu.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // Si hay excepción inesperada, se crea un tablero por defecto
            this.tablero = new Tablero(8, 8, 12);
            this.tableroUI = new TableroUI(this.tablero);
        }
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

