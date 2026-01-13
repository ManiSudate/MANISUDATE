import java.util.ArrayList;
import java.util.Collections;

public class Cartelle {

    private int[][] cartella;
    private boolean[][] segnati;
    private int numeriPresi;
    private boolean[] amboFatto;
    private boolean[] ternoFatto;
    private boolean[] quaternaFatto;
    private boolean[] cinquinaFatto;



    private final String RESET = "\u001B[0m";
    private final String ROSSO = "\u001B[31m";

    public Cartelle() {
        cartella = new int[3][9];
        segnati = new boolean[3][9];
        numeriPresi = 0;
        amboFatto = new boolean[3];
        ternoFatto = new boolean[3];
        quaternaFatto = new boolean[3];
        cinquinaFatto = new boolean[3];


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
        }
    }



    public int numeriSegnatiInRiga(int r) {
        int count = 0;
        for (int c = 0; c < 9; c++) {
            if (segnati[r][c]) count++;
        }
        return count;
    }

    public boolean isAmboFatto(int r) {
        return amboFatto[r];
    }

    public boolean isTernoFatto(int r) {
        return ternoFatto[r];
    }

    public boolean isQuaternaFatto(int r) {
        return quaternaFatto[r];
    }

    public boolean isCinquinaFatto(int r) {
        return cinquinaFatto[r];
    }

    public void setAmboFatto(int r) {
        amboFatto[r] = true;
    }

    public void setTernoFatto(int r) {
        ternoFatto[r] = true;
    }

    public void setQuaternaFatto(int r) {
        quaternaFatto[r] = true;
    }

    public void setCinquinaFatto(int r) {
        cinquinaFatto[r] = true;
    }

    public boolean isTombola() {
        return numeriPresi == 15;
    }



    public int getNumeriPresi() {
        return numeriPresi;
    }

    public void stampaCartella() {
        for (int r = 0; r < 3; r++) {
            stampaRiga(r);
            System.out.println();
        }
    }

    public void stampaRiga(int r) {
        for (int j = 0; j < 9; j++) {
            if (cartella[r][j] == 0) {
                System.out.print("[  ] ");
            } else if (segnati[r][j]) {
                System.out.print(ROSSO + "[" + String.format("%2d", cartella[r][j]) + "] " + RESET);
            } else {
                System.out.print("[" + String.format("%2d", cartella[r][j]) + "] ");
            }
        }
    }
}
