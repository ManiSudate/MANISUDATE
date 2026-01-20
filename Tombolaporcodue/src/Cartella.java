import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cartella {
    private Casella[][] cartella;

    public Cartella() {
        cartella = new Casella[3][9];
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                cartella[i][j] = new Casella(0);
            }
        }

        List<Integer> colonneOn = new ArrayList<>(5);
        int valueColonnaOn = 0;
        for (int i = 0; i < 3; i++) {
            colonneOn.clear();
            int numeriInseriti = 0;

            while (colonneOn.size() < 5) {
                int c = r.nextInt(9);
                if (!colonneOn.contains(c)) {
                    colonneOn.add(c);
                }
            }

            Collections.sort(colonneOn);
            for (int c = 0; c < 5; c++) {
                int col = colonneOn.get(c);
                int numero = (r.nextInt(9) + (col * 10) + 1);
                cartella[i][col] = new Casella(numero);
            }

        }
    }

    public void controllaNumero(int numero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (cartella[i][j].getNumero() == numero) {
                    cartella[i][j].segna();
                    System.out.println("Numero preso: "+ numero);
                }
            }
        }
    }

    public void stampa() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("[ "+ cartella[i][j] + " ]"+" ");
            }
            System.out.println();
        }
    }

}
