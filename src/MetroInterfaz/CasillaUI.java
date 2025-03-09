/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetroInterfaz;

import LogicaJuego.Casilla;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Clase CasillaUI que maneja un JButton (interfaz) para una Casilla (lógica).
 * Conecta los eventos de ratón a la ejecución de BFS/DFS o marcado de banderas.
 */
 public class CasillaUI {
    private Casilla casilla;    // Lógica
    private TableroUI tableroUI; 
    private JButton boton;      // Botón que se muestra en la interfaz

    /**
     * Constructor que asocia la Casilla (lógica) con la interfaz (TableroUI),
     * y configura el JButton con su MouseListener.
     * @param casilla Lógica de la casilla.
     * @param tabUI   Interfaz principal TableroUI.
     */
    public CasillaUI(Casilla casilla, TableroUI tabUI) {
        this.casilla = casilla;
        this.tableroUI = tabUI;
        this.boton = new JButton();
        boton.setBackground(Color.getHSBColor(0.067f, 1f, 1f));
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        // Listener para clic izquierdo y derecho
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tableroUI.getLogica().isGameOver()) return;
                
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (!casilla.isBarrida() && !casilla.isMarcada()) {
                        if (casilla.isTieneMina()) {
                            revelarMina();
                            tableroUI.derrota(); 
                        } else {
                            if (tableroUI.getLogica().isUsaBFS()) {
                                tableroUI.getLogica().barridoBFS(casilla);
                            } else {
                                tableroUI.getLogica().barridoDFS(casilla);
                            }
                            tableroUI.victoria();
                        }
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (!casilla.isMarcada() && 
                        tableroUI.getLogica().getMinasRestantes() <= 0) {
                        return;
                    }
                    marcar();
                    tableroUI.victoria();
                }
                // Refrescar toda la interfaz de casillas
                tableroUI.refrescarTableroUI();
            }
        });
        
        actualizarBoton(); 
    }
    
    /** @return El JButton que representa la CasillaUI en pantalla. */
    public JButton getBoton() {
        return boton;
    }
    
    /** @return La Casilla lógica asociada a esta UI. */
    public Casilla getCasilla() {
        return casilla;
    }
    
    /**
     * Revela la bomba gráficamente en caso de clic en una mina,
     * cambiando el texto y color del botón.
     */
    public void revelarMina() {
        boton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        boton.setText("💣");
        boton.setBackground(Color.RED);
        boton.setForeground(Color.WHITE);
        casilla.setBarrida(true);
    }
    
    /**
     * Coloca o quita una bandera (🚩) en la casilla, según esté marcada o no.
     * Actualiza la lógica (minasRestantes) y refresca el botón.
     */
    public void marcar() {
        if (casilla.isBarrida()) return;
        if (tableroUI.getLogica().isGameOver()) return;
        if (!casilla.isMarcada() && 
            tableroUI.getLogica().getMinasRestantes() <= 0) {
            return;
        }
        casilla.setMarcada(!casilla.isMarcada());
        if (casilla.isMarcada()) {
            tableroUI.getLogica().setMinasRestantes(
                tableroUI.getLogica().getMinasRestantes() - 1
            );
            boton.setFont(new Font("SansSerif", Font.PLAIN, 24));
            boton.setText("🚩");
            boton.setBackground(Color.BLUE);
            boton.setForeground(Color.WHITE);
        } else {
            tableroUI.getLogica().setMinasRestantes(
                tableroUI.getLogica().getMinasRestantes() + 1
            );
        }
        tableroUI.updateMinasLabel();
    }
    
    /**
     * Ajusta el botón según el estado actual de la casilla (marcada, barrida, etc.)
     */
    public void actualizarBoton() {
        if (casilla.isMarcada()) {
            boton.setText("🚩");
            boton.setBackground(Color.BLUE);
            boton.setForeground(Color.WHITE);
            boton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        } else if (casilla.isBarrida()) {
            if (casilla.getMinasAdyacentes() > 0) {
                boton.setText(String.valueOf(casilla.getMinasAdyacentes()));
            } else {
                boton.setText("");
            }
            boton.setBackground(Color.WHITE);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            
            int m = casilla.getMinasAdyacentes();
            if (m == 1) {
                boton.setForeground(Color.GREEN.darker());
            } else if (m == 2) {
                boton.setForeground(Color.BLUE);
            } else if (m == 3) {
                boton.setForeground(Color.ORANGE);
            } else if (m >= 4) {
                boton.setForeground(Color.RED);
            } else {
                boton.setForeground(Color.BLACK);
            }
        } else {
            boton.setText("");
            boton.setBackground(Color.getHSBColor(0.067f, 1f, 1f));
            boton.setForeground(Color.BLACK);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
        }
    }
}
