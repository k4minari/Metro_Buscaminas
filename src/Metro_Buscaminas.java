
import MetroInterfaz.Start;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author francisco
 */
public class Metro_Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creación de un tablero 3x3 de prueba
        // Se crea un tablero de 3 filas x 4 columnas
        Tablero t = new Tablero(3, 4);
        System.out.println("Tablero (3x4):");
        t.mostrarTablero();
        
    }
    
}
