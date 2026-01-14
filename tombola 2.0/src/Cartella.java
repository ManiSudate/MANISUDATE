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
        for (int i = 0; i < 3; i++) {
            int numeriInseriti = 0;
            while (numeriInseriti < 5) {
                int colonna = r.nextInt(9);
                if (cartella[i][colonna].getNumero() == 0) {
                    int numero = r.nextInt(90) + 1;
                    cartella[i][colonna] = new Casella(numero);
                    numeriInseriti++;
                }
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
                System.out.print("["+cartella[i][j]+"]" + " ");
            }
            System.out.println();
        }
    }
}