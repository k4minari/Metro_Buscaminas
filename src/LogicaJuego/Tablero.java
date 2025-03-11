package LogicaJuego;

import EDDauxiliares.Cola; 
import EDDauxiliares.ListaCasillas;
import EDDauxiliares.NodoCasilla;
import EDDauxiliares.NodoLista;
import EDDauxiliares.Pila;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;


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
    private int numMinas;
    private ListaCasillas casillas;
    private ListaCasillas listaMinas;
    private boolean usaBFS;
    private boolean gameOver;
    private int segundosTranscurridos;
    private int minasRestantes; 
    private Graph arbolRecorrido; // Para BFS/DFS con GraphStream
    
    /**
     * Constructor que crea un Tablero con las dimensiones dadas
     * y un número de minas. Asigna minas aleatoriamente.
     * @param filas    Número de filas
     * @param columnas Número de columnas
     * @param numMinas Cantidad de minas a colocar
     */
    public Tablero(int filas, int columnas, int numMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.numMinas = numMinas;
        this.minasRestantes = numMinas;
        this.usaBFS = true;
        this.gameOver = false;
        this.casillas = new ListaCasillas();
        this.listaMinas = new ListaCasillas();
        this.segundosTranscurridos = 0;
        
        inicializarCasillas();
        asignarMinas();
        conectarCasillas();
        calcularMinasAdyacentes();
    }
    
    /**
     * Constructor alternativo para un tablero "vacío" (sin minas aleatorias).
     * @param filas    Número de filas
     * @param columnas Número de columnas
     */
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.numMinas = 0;
        this.minasRestantes = 0;
        this.usaBFS = true;
        this.gameOver = false;
        this.casillas = new ListaCasillas();
        this.listaMinas = new ListaCasillas();
        
        inicializarCasillas();   
        conectarCasillas();  
    }

    // Getters/Setters (sin explicar en detalle):
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    public int getNumMinas() { return numMinas; }
    public boolean isUsaBFS() { return usaBFS; }
    public void setUsaBFS(boolean usaBFS) { this.usaBFS = usaBFS; }
    public boolean isGameOver() { return gameOver; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }
    public int getSegundosTranscurridos() { return segundosTranscurridos; }
    public void setSegundosTranscurridos(int s) { this.segundosTranscurridos = s; }
    public int getMinasRestantes() { return minasRestantes; }
    public void setMinasRestantes(int mr) { this.minasRestantes = mr; }
    public ListaCasillas getCasillas() { return casillas; }
    public ListaCasillas getListaMinas() { return listaMinas; }
    
    /**
     * Marca la partida como perdida (gameOver=true).
     */
    public void derrota() {
        gameOver = true;
    }
    
    /**
     * Verifica si se han marcado todas las minas (checkIfWin).
     * Si todas están marcadas, gameOver pasa a true indicando victoria.
     */
    public void victoria() {
        NodoCasilla actual = listaMinas.getCabeza();
        while (actual != null) {
            if (!actual.getCasilla().isMarcada()) {
                return; 
            }
            actual = actual.getSiguiente();
        }
        gameOver = true; 
    }
    
    /**
     * Crea todas las casillas (una por cada posición fila,columna)
     * y las almacena en la lista de casillas.
     */
    private void inicializarCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla c = new Casilla(i, j);
                casillas.agregar(c);
            }
        }
    }
    
    /**
     * Asigna minas aleatoriamente hasta completar numMinas.
     * Utiliza un Random y busca casillas sin mina para colocarla.
     */
    private void asignarMinas() {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < numMinas) {
            int f = rand.nextInt(filas);
            int c = rand.nextInt(columnas);
            Casilla cas = casillas.buscar(f, c);
            if (cas != null && !cas.isTieneMina()) {
                cas.setTieneMina(true);
                listaMinas.agregar(cas);
                minasColocadas++;
            }
        }
    }
    
    /**
     * Conecta cada casilla con sus vecinas (hasta 8 posibles),
     * usando la lista de adyacencia.
     */
    private void conectarCasillas() {
        NodoCasilla actual = casillas.getCabeza();
        while (actual != null) {
            Casilla cas = actual.getCasilla();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int nx = cas.getFila() + dx;
                    int ny = cas.getColumna() + dy;
                    Casilla vecina = casillas.buscar(nx, ny);
                    if (vecina != null) {
                        cas.getAdyacentes().agregar(vecina);
                    }
                }
            }
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Calcula cuántas minas hay alrededor de cada casilla (minasAdyacentes).
     * Se salta las casillas que ya tienen mina.
     */
    private void calcularMinasAdyacentes() {
        NodoCasilla actual = casillas.getCabeza();
        while (actual != null) {
            Casilla c = actual.getCasilla();
            if (!c.isTieneMina()) {
                int contador = 0;
                NodoLista ady = c.getAdyacentes().getCabeza();
                while (ady != null) {
                    if (ady.getCasilla().isTieneMina()) {
                        contador++;
                    }
                    ady = ady.getSiguiente();
                }
                c.setMinasAdyacentes(contador);
            }
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Barrido BFS (Breadth-First Search) que se expande solo en casillas 
     * cuyo minasAdyacentes == 0, hasta que se topa con celdas con adyacentes>0.
     * @param inicio Casilla desde donde se inicia la expansión BFS.
     */
    public void barridoBFS(Casilla inicio) {
        if (gameOver) return;
        arbolRecorrido = new SingleGraph("Arbol BFS");
        System.setProperty("org.graphstream.ui", "swing");
        arbolRecorrido.setAttribute("ui.stylesheet", getArbolStyle());

        boolean[][] visited = new boolean[filas][columnas];
        Cola cola = new Cola();

        // Encolamos la casilla inicial y la marcamos como visitada
        cola.encolar(inicio);
        visited[inicio.getFila()][inicio.getColumna()] = true;

        // Creamos un nodo en el grafo para la casilla inicial
        Node nodoInicio = arbolRecorrido.addNode(inicio.getID());
        nodoInicio.setAttribute("ui.label", inicio.getID());
        nodoInicio.setAttribute("ui.style", "fill-color: red;");

        // Mientras haya casillas en la cola
        while (!cola.estaVacia()) {
            Casilla actual = cola.desencolar();
            // Marcamos como barrida si no está barrida ni tiene mina
            if (!actual.isBarrida() && !actual.isTieneMina()) {
                actual.setBarrida(true);
            }
            // Solo expandimos si no hay minas alrededor (minasAdyacentes == 0)
            if (actual.getMinasAdyacentes() == 0) {
                NodoLista ady = actual.getAdyacentes().getCabeza();
                while (ady != null) {
                    Casilla vecino = ady.getCasilla();
                    // Expandimos a vecinos no visitados y sin mina
                    if (!vecino.isTieneMina() 
                            && !visited[vecino.getFila()][vecino.getColumna()]) {
                        
                        visited[vecino.getFila()][vecino.getColumna()] = true;
                        cola.encolar(vecino);

                        // Añadimos nodo al grafo si no existe
                        if (arbolRecorrido.getNode(vecino.getID()) == null) {
                            Node n = arbolRecorrido.addNode(vecino.getID());
                            n.setAttribute("ui.label", vecino.getID());
                        }

                        // Creamos arista (edge) en el grafo si no existe
                        String edgeId = actual.getID() + "-" + vecino.getID();
                        if (arbolRecorrido.getEdge(edgeId) == null) {
                            arbolRecorrido.addEdge(edgeId, 
                                                   actual.getID(), 
                                                   vecino.getID());
                        }
                    }
                    ady = ady.getSiguiente();
                }
            }
        }
    }
    
    /**
     * Barrido DFS (Depth-First Search) que se expande solo en casillas 
     * cuyo minasAdyacentes == 0, hasta que encuentra celdas con adyacentes>0.
     * @param inicio Casilla desde donde se inicia la expansión DFS.
     */
    public void barridoDFS(Casilla inicio) {
        if (gameOver) return;
        arbolRecorrido = new SingleGraph("Arbol DFS");
        System.setProperty("org.graphstream.ui", "swing");
        arbolRecorrido.setAttribute("ui.stylesheet", getArbolStyle());

        boolean[][] visited = new boolean[filas][columnas];
        Pila pila = new Pila();

        // Apilamos la casilla inicial y la marcamos como visitada
        pila.apilar(inicio);
        visited[inicio.getFila()][inicio.getColumna()] = true;

        // Creamos el nodo inicial en el grafo
        Node nodoInicio = arbolRecorrido.addNode(inicio.getID());
        nodoInicio.setAttribute("ui.label", inicio.getID());
        nodoInicio.setAttribute("ui.style", "fill-color: red;");

        // Mientras la pila no esté vacía
        while (!pila.estaVacia()) {
            Casilla actual = pila.desapilar();
            // Marcamos como barrida si no está barrida ni tiene mina
            if (!actual.isBarrida() && !actual.isTieneMina()) {
                actual.setBarrida(true);
            }
            // Expandimos solo si minasAdyacentes == 0
            if (actual.getMinasAdyacentes() == 0) {
                NodoLista ady = actual.getAdyacentes().getCabeza();
                while (ady != null) {
                    Casilla vecino = ady.getCasilla();
                    // Apilar vecino no visitado y sin mina
                    if (!vecino.isTieneMina() 
                            && !visited[vecino.getFila()][vecino.getColumna()]) {
                        
                        visited[vecino.getFila()][vecino.getColumna()] = true;
                        pila.apilar(vecino);

                        // Añadimos nodo al grafo si no existe
                        if (arbolRecorrido.getNode(vecino.getID()) == null) {
                            Node n = arbolRecorrido.addNode(vecino.getID());
                            n.setAttribute("ui.label", vecino.getID());
                        }

                        // Creamos arista en el grafo si no existe
                        String edgeId = actual.getID() + "-" + vecino.getID();
                        if (arbolRecorrido.getEdge(edgeId) == null) {
                            arbolRecorrido.addEdge(edgeId, 
                                                   actual.getID(), 
                                                   vecino.getID());
                        }
                    }
                    ady = ady.getSiguiente();
                }
            }
        }
    }
    
    /** @return El grafo GraphStream donde se almacenan las aristas del último barrido BFS/DFS. */
    public Graph getArbolRecorrido() {
        return arbolRecorrido;
    }
    
    /**
     * @return Una cadena de estilos CSS para la visualización en GraphStream.
     */
    public String getArbolStyle() {
        return
            "node {" +
            "   fill-color: white;" +
            "   size: 15px;" +
            "   text-size: 12px;" +
            "   stroke-mode: plain;" +
            "   stroke-color: black;" +
            "}" +
            "edge {" +
            "   fill-color: black;" +
            "   size: 1px;" +
            "}" +
            "graph {" +
            "   fill-color: white;" +
            "}";
    }

    /**
     * Guarda la partida en un archivo CSV, preguntando previamente con un JFileChooser.La primera línea incluye: filas,columnas,numMinas,minasRestantes,usaBFS,gameOver,segundosTranscurridos
 y luego cada casilla en líneas separadas.
     * @return 
     * @throws java.io.IOException
     */
    public boolean guardarCSV() throws IOException {
    JFileChooser fc = new JFileChooser();
    fc.setDialogTitle("Guardar partida en CSV");
    
    int userSelection = fc.showSaveDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File archivo = fc.getSelectedFile();
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            // Guardar datos en el CSV...
            // 1) Primera línea con la configuración general
                pw.println(
                    this.filas + "," 
                    + this.columnas + "," 
                    + this.numMinas + "," 
                    + this.minasRestantes + "," 
                    + this.usaBFS + "," 
                    + this.gameOver + ","
                    + this.segundosTranscurridos
                );
                
                // 2) Cada casilla en su propia línea
                // fila,columna,tieneMina,barrida,marcada,minasAdyacentes
                NodoCasilla actual = this.casillas.getCabeza();
                while (actual != null) {
                    Casilla c = actual.getCasilla();
                    pw.println(
                        c.getFila() + "," 
                        + c.getColumna() + "," 
                        + c.isTieneMina() + "," 
                        + c.isBarrida() + "," 
                        + c.isMarcada() + "," 
                        + c.getMinasAdyacentes()
                    );
                    actual = actual.getSiguiente();}
            JOptionPane.showMessageDialog(
                null,
                "Partida guardada en:\n" + archivo.getAbsolutePath()
            );
            return true; // Indica que el guardado fue exitoso

        }catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Error al guardar la partida.\n" + e.getMessage()
            );
            return false;
        }
    } else {
        // Se canceló el guardado
        JOptionPane.showMessageDialog(
            null,
            "Operación cancelada. No se guardó la partida."
        );
        return false;
    }
}

    /**
     * Crea un Tablero a partir de un archivo CSV.
     * La primera línea contiene la configuración: filas,columnas,numMinas,minasRestantes,usaBFS,gameOver,segundosTranscurridos
     * Luego cada línea describe una casilla con: fila,columna,tieneMina,barrida,marcada,minasAdyacentes
     * 
     * @param archivo Archivo CSV a leer.
     * @return El Tablero reconstruido según el CSV.
     * @throws IOException Si el archivo no es válido o hay error de lectura.
     */
    /**
     * Crea un Tablero a partir de un archivo CSV.
     * La primera línea contiene la configuración: filas,columnas,numMinas,minasRestantes,usaBFS,gameOver,segundosTranscurridos
     * Luego cada línea describe una casilla con: fila,columna,tieneMina,barrida,marcada,minasAdyacentes
     * 
     * @param archivo Archivo CSV a leer.
     * @return El Tablero reconstruido según el CSV.
     * @throws IOException Si el archivo no es válido o hay error de lectura.
     */
    public static Tablero cargarCSV(File archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            
            //Leer config general:
            String configLine = br.readLine();
            if (configLine == null) {
                throw new IOException("Archivo CSV vacío o inválido");
            }
            
            String[] partsConfig = configLine.split(",");
            int filas = Integer.parseInt(partsConfig[0]);
            int columnas = Integer.parseInt(partsConfig[1]);
            int numMinas = Integer.parseInt(partsConfig[2]);
            int minasRestantes = Integer.parseInt(partsConfig[3]);
            boolean usaBFS = Boolean.parseBoolean(partsConfig[4]);
            boolean gameOver = Boolean.parseBoolean(partsConfig[5]);
            int segs = Integer.parseInt(partsConfig[6]);
            
            //Crear Tablero "vacío" sin asignarMinas:
            Tablero t = new Tablero(filas, columnas); 
            // Ajustar manualmente lo leído:
            t.numMinas = numMinas;
            t.minasRestantes = minasRestantes;
            t.usaBFS = usaBFS;
            t.gameOver = gameOver;
            t.segundosTranscurridos = segs;
            
            //Leer resto de líneas (casillas)
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int f = Integer.parseInt(parts[0]);
                int c = Integer.parseInt(parts[1]);
                boolean tieneMina = Boolean.parseBoolean(parts[2]);
                boolean barrida   = Boolean.parseBoolean(parts[3]);
                boolean marcada   = Boolean.parseBoolean(parts[4]);
                int ady           = Integer.parseInt(parts[5]);
                
                Casilla cas = t.casillas.buscar(f, c);
                if (cas != null) {
                    cas.setTieneMina(tieneMina);
                    cas.setBarrida(barrida);
                    cas.setMarcada(marcada);
                    cas.setMinasAdyacentes(ady);
                    
                    if (tieneMina) {
                        t.listaMinas.agregar(cas);
                    }
                }
            }
            //Retornar Tablero
            return t;
        }
    }
}