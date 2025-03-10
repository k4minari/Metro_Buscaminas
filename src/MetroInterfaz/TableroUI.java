/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetroInterfaz;
import EDDauxiliares.ListaCasillaUI;
import EDDauxiliares.NodoCasilla;
import LogicaJuego.Casilla;
import LogicaJuego.Tablero;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import org.graphstream.graph.Graph;
import org.graphstream.ui.view.Viewer;


/**
 * Clase TableroUI que hereda de JFrame y construye la interfaz gráfica
 * para mostrar el Tablero. Maneja el Timer de tiempo, las etiquetas de
 * "Tiempo" y "Minas restantes", y crea CasillaUI para cada celda.
 */

public class TableroUI extends JFrame {
    private final Tablero logica;
    private final JLabel tiempoNumLabel;
    private final JLabel minasNumLabel;
    private Timer timerSwing;
    private int segundosTranscurridosUI;
    private final JButton botonCerrar;

    /** Lista enlazada de CasillaUI. */
    private final ListaCasillaUI listaCasillasUI;

    /**
     * Constructor que recibe el Tablero lógico y crea la ventana (JFrame),
     * organizando la interfaz en distintos paneles, un botón de cierre (X),
     * las etiquetas de tiempo y minas, y el Timer.
     * 
     * @param logica Tablero que contiene la lógica del juego.
     */
    public TableroUI(Tablero logica) {
        this.logica = logica;
        this.listaCasillasUI = new ListaCasillaUI();
        // Iniciamos el contador de la UI con el valor actual del tablero
        this.segundosTranscurridosUI = logica.getSegundosTranscurridos();
        
        setTitle("Buscaminas");
        setUndecorated(true);
        
        int cellSize = 50;
        int boardWidth = logica.getColumnas() * cellSize;
        int boardHeight = logica.getFilas() * cellSize;
        int frameWidth = boardWidth + 40;
        int frameHeight = boardHeight + 70;
        
        setSize(frameWidth, frameHeight);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        // Botón "X" para salir
        botonCerrar = new JButton("X");
        botonCerrar.setBounds(frameWidth - 20, 0, 20, 20);
        botonCerrar.setForeground(Color.BLACK);
        botonCerrar.setBackground(Color.RED);
        botonCerrar.setBorder(null);
        botonCerrar.setFocusPainted(false);
        botonCerrar.setFont(new Font("Arial", Font.BOLD, 10));
        botonCerrar.addActionListener(e -> {
            int opcion = JOptionPane.showOptionDialog(
                this,
                "¿Desea cerrar sin guardar o guardar antes?",
                "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Cerrar sin guardar", "Guardar y salir", "Cancelar"},
                "Cerrar sin guardar"
            );
            if (opcion == 0) {
                this.dispose();
                Start menu = new Start();
                menu.setVisible(true);
            } else if (opcion == 1) {
                // Opción "Guardar y salir"
                boolean guardado;
                guardado = logica.guardarCSV(); // Retorna `true` si se guardó correctamente
                if (guardado) { // Solo cerrar si el guardado fue exitoso
                    this.dispose();
                    Start menu = new Start();
                    menu.setVisible(true);
        }}
        });
        add(botonCerrar);

        // Panel superior (tiempo y minas)
        JLabel tiempoTagLabel = new JLabel("Tiempo:");
        tiempoTagLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tiempoNumLabel = new JLabel("0", SwingConstants.CENTER);
        tiempoNumLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        JLabel minasTagLabel = new JLabel("Minas restantes:");
        minasTagLabel.setFont(new Font("Arial", Font.BOLD, 18));
        minasNumLabel = new JLabel(String.valueOf(logica.getMinasRestantes()), SwingConstants.CENTER);
        minasNumLabel.setFont(new Font("Arial", Font.BOLD, 18));
        minasNumLabel.setForeground(Color.RED);
        
        JPanel tiempoPanel = new JPanel(new FlowLayout());
        tiempoPanel.add(tiempoTagLabel);
        tiempoPanel.add(tiempoNumLabel);
        
        JPanel minasPanel = new JPanel(new FlowLayout());
        minasPanel.add(minasTagLabel);
        minasPanel.add(minasNumLabel);
        
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(tiempoPanel);
        topPanel.add(minasPanel);
        add(topPanel, BorderLayout.NORTH);
        
        // Panel central con las CasillaUI
        JPanel tableroPanel = new JPanel(new GridLayout(logica.getFilas(), logica.getColumnas()));
        
        NodoCasilla actual = logica.getCasillas().getCabeza();
        while (actual != null) {
            Casilla c = actual.getCasilla();
            CasillaUI cui = new CasillaUI(c, this);
            tableroPanel.add(cui.getBoton());
            listaCasillasUI.agregar(cui);
            
            actual = actual.getSiguiente();
        }
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        mainPanel.add(tableroPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
        
        // Panel inferior (controles BFS/DFS + VerArbol)
        JRadioButton bfsButton = new JRadioButton("BFS", true);
        JRadioButton dfsButton = new JRadioButton("DFS");
        bfsButton.setFont(new Font("Arial", Font.BOLD, 16));
        dfsButton.setFont(new Font("Arial", Font.BOLD, 16));
        bfsButton.addActionListener(e -> {
            logica.setUsaBFS(true);
            bfsButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            dfsButton.setBorder(null);
        });
        dfsButton.addActionListener(e -> {
            logica.setUsaBFS(false);
            dfsButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            bfsButton.setBorder(null);
        });
        
        ButtonGroup group = new ButtonGroup();
        group.add(bfsButton);
        group.add(dfsButton);
        
        JButton verArbolBtn = new JButton("Ver Arbol de Barrida");
        verArbolBtn.setFont(new Font("Arial", Font.BOLD, 16));
        verArbolBtn.setBackground(Color.LIGHT_GRAY);
        verArbolBtn.addActionListener(e -> mostrarArbolRecorrido());
        
        JPanel controlPanel = new JPanel();
        controlPanel.add(bfsButton);
        controlPanel.add(dfsButton);
        controlPanel.add(verArbolBtn);
        
        add(controlPanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        iniciarTimer();
    }

    /** @return El Tablero (lógica) asociado a esta interfaz. */
    public Tablero getLogica() {
        return logica;
    }

    /**
     * Actualiza la etiqueta de minas restantes con el valor que tenga la lógica.
     */
    public void updateMinasLabel() {
        minasNumLabel.setText(String.valueOf(logica.getMinasRestantes()));
    }

    /**
     * Inicia un Timer que cada segundo incrementa 'segundosTranscurridosUI',
     * lo muestra en la etiqueta y lo guarda en el Tablero.
     */
    private void iniciarTimer() {
        timerSwing = new Timer(1000, e -> {
            segundosTranscurridosUI++;
            tiempoNumLabel.setText(String.valueOf(segundosTranscurridosUI));
            logica.setSegundosTranscurridos(segundosTranscurridosUI);
        });
        timerSwing.start();
    }

    /**
     * Marca la partida como derrota en la lógica, detiene el timer y muestra un mensaje.
     */
    public void derrota() {
        logica.derrota();
        if (timerSwing != null) timerSwing.stop();
        Loser perder = new Loser();
        perder.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Verifica si se ha ganado (checkIfWin en la lógica) y si es así,
     * detiene el timer y muestra un mensaje.
     */
    public void victoria() {
        logica.victoria();
        if (logica.isGameOver()) {
            if (timerSwing != null) timerSwing.stop();
            Winner ganar = new Winner();
            ganar.setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * Llama al método refrescarTodo() de la lista enlazada 
     * para que cada CasillaUI actualice su apariencia.
     */
    public void refrescarTableroUI() {
        listaCasillasUI.refrescar();
    }

    /**
     * Muestra el grafo GraphStream (arbolRecorrido) que se generó 
     * durante BFS/DFS. Si no se ha hecho aún, avisa al usuario.
     */
    public void mostrarArbolRecorrido() {
        Graph g = logica.getArbolRecorrido();
        if (g == null) {
            JOptionPane.showMessageDialog(this, "Aún no se ha realizado ningún barrido.");
            return;
        }
        Viewer viewer = g.display(false);
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        viewer.enableAutoLayout();
    }
}
