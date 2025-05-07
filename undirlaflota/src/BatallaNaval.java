/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aaa
 * 
 *   TIME: HH:MM DD/MM/AAAA
 *   TURNO N: 
 *   
 * 
 */

import java.util.*;

public class BatallaNaval {

    static final int TAM = 8;
    static final String AGUA = "~";
    static final String BARCO = "O";
    static final String IMPACTO = "X";
    static final String FALLO = "*";

    static String[][] tableroJugador = new String[TAM][TAM];
    static String[][] tableroDisparosJugador = new String[TAM][TAM];
    static String[][] tableroIA = new String[TAM][TAM];
    static String[][] tableroDisparosIA = new String[TAM][TAM];

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static int[] ultimoImpacto = null;

    public static void main(String[] args) {
        inicializarTablero(tableroJugador);
        inicializarTablero(tableroDisparosJugador);
        inicializarTablero(tableroIA);
        inicializarTablero(tableroDisparosIA);

        System.out.println("\u00bfQuieres colocar tus barcos manualmente o aleatoriamente? (M/A)");
        char opcion = sc.next().toUpperCase().charAt(0);
        if (opcion == 'M') {
            System.out.println("Coloca tus barcos manualmente:");
            colocarBarco(tableroJugador, "Portaviones (5)", 5);
            colocarBarco(tableroJugador, "Destructor (4)", 4);
            colocarBarco(tableroJugador, "Submarino 1 (3)", 3);
            colocarBarco(tableroJugador, "Submarino 2 (3)", 3);
            colocarBarco(tableroJugador, "Fragata (2)", 2);
        } else {
            System.out.println("Colocando los barcos aleatoriamente...");
            colocarBarcosAleatorios(tableroJugador);
        }

        colocarBarcosAleatorios(tableroIA);

        while (true) {
            System.out.println("\nTu tablero de disparos:");
            imprimirTablero(tableroDisparosJugador, true);
            System.out.println("\nTu tablero de defensa (donde dispara la IA):");
            imprimirTablero(tableroJugador, false);

            System.out.println("\nTurno del jugador:");
            disparar(tableroIA, tableroDisparosJugador);

            if (juegoTerminado(tableroIA)) {
                System.out.println("\n\u00a1Ganaste! Todos los barcos de la IA han sido hundidos.");
                break;
            }

            System.out.println("\nTurno de la IA:");
            disparoIA();

            if (juegoTerminado(tableroJugador)) {
                System.out.println("\n\u00a1Perdiste! Todos tus barcos han sido hundidos.");
                break;
            }
        }
    }

    static void inicializarTablero(String[][] tablero) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                tablero[i][j] = AGUA;
            }
        }
    }

    static void imprimirTablero(String[][] tablero, boolean oculto) {
        System.out.print("  ");
        for (int i = 0; i < TAM; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < TAM; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAM; j++) {
                String c = tablero[i][j];
                if (oculto && c.equals(BARCO)) System.out.print(AGUA + " ");
                else System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static void colocarBarco(String[][] tablero, String nombre, int tam) {
        boolean colocado = false;
        while (!colocado) {
            imprimirTablero(tablero, false);
            System.out.println("Coloca el " + nombre);
            System.out.print("Fila inicial: ");
            int fila = sc.nextInt();
            System.out.print("Columna inicial: ");
            int col = sc.nextInt();
            System.out.print("\u00bfHorizontal (H) o Vertical (V)?: ");
            char dir = sc.next().toUpperCase().charAt(0);
            if (puedeColocar(tablero, fila, col, tam, dir)) {
                for (int i = 0; i < tam; i++) {
                    if (dir == 'H') tablero[fila][col + i] = BARCO;
                    else tablero[fila + i][col] = BARCO;
                }
                colocado = true;
            } else {
                System.out.println("No se puede colocar ahí. Intenta otra posición.");
            }
        }
    }

    static void colocarBarcosAleatorios(String[][] tablero) {
        colocarBarcoAleatorio(tablero, 5);
        colocarBarcoAleatorio(tablero, 4);
        colocarBarcoAleatorio(tablero, 3);
        colocarBarcoAleatorio(tablero, 3);
        colocarBarcoAleatorio(tablero, 2);
    }

    static boolean puedeColocar(String[][] tablero, int fila, int col, int tam, char dir) {
        if (dir == 'H') {
            if (col + tam > TAM) return false;
            for (int i = 0; i < tam; i++) {
                if (!tablero[fila][col + i].equals(AGUA)) return false;
            }
        } else if (dir == 'V') {
            if (fila + tam > TAM) return false;
            for (int i = 0; i < tam; i++) {
                if (!tablero[fila + i][col].equals(AGUA)) return false;
            }
        } else return false;
        return true;
    }

    static void colocarBarcoAleatorio(String[][] tablero, int tam) {
        boolean colocado = false;
        while (!colocado) {
            int fila = rand.nextInt(TAM);
            int col = rand.nextInt(TAM);
            char dir = rand.nextBoolean() ? 'H' : 'V';
            if (puedeColocar(tablero, fila, col, tam, dir)) {
                for (int i = 0; i < tam; i++) {
                    if (dir == 'H') tablero[fila][col + i] = BARCO;
                    else tablero[fila + i][col] = BARCO;
                }
                colocado = true;
            }
        }
    }

    static void disparar(String[][] tableroOponente, String[][] tableroDisparos) {
        boolean valido = false;
        while (!valido) {
            System.out.print("Fila a disparar: ");
            int fila = sc.nextInt();
            System.out.print("Columna a disparar: ");
            int col = sc.nextInt();
            if (fila >= 0 && fila < TAM && col >= 0 && col < TAM && tableroDisparos[fila][col].equals(AGUA)) {
                if (tableroOponente[fila][col].equals(BARCO)) {
                    System.out.println("\u00a1Impacto!");
                    tableroDisparos[fila][col] = IMPACTO;
                    tableroOponente[fila][col] = IMPACTO;
                } else {
                    System.out.println("Agua.");
                    tableroDisparos[fila][col] = FALLO;
                }
                valido = true;
            } else {
                System.out.println("Disparo inválido o repetido. Intenta de nuevo.");
            }
        }
    }

    static void disparoIA() {
        int[][] direcciones = {{-1,0},{1,0},{0,-1},{0,1}};
        if (ultimoImpacto != null) {
            for (int[] d : direcciones) {
                int nuevaFila = ultimoImpacto[0] + d[0];
                int nuevaCol = ultimoImpacto[1] + d[1];
                if (nuevaFila >= 0 && nuevaFila < TAM && nuevaCol >= 0 && nuevaCol < TAM && tableroDisparosIA[nuevaFila][nuevaCol].equals(AGUA)) {
                    procesarDisparoIA(nuevaFila, nuevaCol);
                    return;
                }
            }
        }

        boolean disparado = false;
        while (!disparado) {
            int fila = rand.nextInt(TAM);
            int col = rand.nextInt(TAM);
            if (tableroDisparosIA[fila][col].equals(AGUA)) {
                procesarDisparoIA(fila, col);
                disparado = true;
            }
        }
    }

    static void procesarDisparoIA(int fila, int col) {
        if (tableroJugador[fila][col].equals(BARCO)) {
            System.out.println("La IA acertó en " + fila + "," + col);
            tableroDisparosIA[fila][col] = IMPACTO;
            tableroJugador[fila][col] = IMPACTO;
            ultimoImpacto = new int[]{fila, col};
        } else {
            System.out.println("La IA falló en " + fila + "," + col);
            tableroDisparosIA[fila][col] = FALLO;
            ultimoImpacto = null;
        }
    }

    static boolean juegoTerminado(String[][] tablero) {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (tablero[i][j].equals(BARCO)) return false;
            }
        }
        return true;
    }
}

