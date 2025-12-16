import java.util.ArrayList;
import java.util.Collections;

public class Cartelle {

    private int[][] cartella;
    private boolean[][] segnati;
    private int numeriPresi;

    // Codici ANSI per i colori
    private final String RESET = "\u001B[0m";
    private final String ROSSO = "\u001B[31m";

    public Cartelle() {
        cartella = new int[3][9];
        segnati = new boolean[3][9];
        numeriPresi = 0;

        // genera numeri per ogni colonna
        ArrayList<Integer>[] colonne = new ArrayList[9];
        for (int c = 0; c < 9; c++) {
            colonne[c] = new ArrayList<>();
            int start = c * 10 + 1;
            int end = (c == 8) ? 90 : start + 9;
            if (c == 0) start = 1;
            if (c == 0) end = 9;
            for (int i = start; i <= end; i++) {
                colonne[c].add(i);
            }
            Collections.shuffle(colonne[c]);
        }

        // assegna 5 numeri per riga
        for (int r = 0; r < 3; r++) {
            ArrayList<Integer> colConNumero = new ArrayList<>();
            while (colConNumero.size() < 5) {
                int c = (int) (Math.random() * 9);
                if (!colConNumero.contains(c)) colConNumero.add(c);
            }
            Collections.sort(colConNumero);
            for (int j = 0; j < 5; j++) {
                int col = colConNumero.get(j);
                cartella[r][col] = colonne[col].remove(0);
            }
        }
    }

    public void controllaNumero(int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (cartella[i][j] == n && !segnati[i][j]) {
                    segnati[i][j] = true;
                    numeriPresi++;
                    System.out.println(ROSSO + "Numero preso: " + n + RESET);

                }
            }
            numeriPresi=0;
        }
    }

    public int getNumeriPresi() {
        return numeriPresi;
    }

    // stampa l’intera cartella
    public void stampaCartella() {
        for (int r = 0; r < 3; r++) {
            stampaRiga(r);
            System.out.println();
        }
    }

    // stampa una singola riga (per stampa affiancata)
    public void stampaRiga(int r) {
        for (int j = 0; j < 9; j++) {
            if (cartella[r][j] == 0) {
                System.out.print("[  ] "); // spazio più grande
            } else if (segnati[r][j]) {
                System.out.print(ROSSO + "[" + String.format("%2d", cartella[r][j]) + "] " + RESET);
            } else {
                System.out.print("[" + String.format("%2d", cartella[r][j]) + "] ");
            }
        }
    }
}
