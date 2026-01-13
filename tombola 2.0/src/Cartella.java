import java.util.Random;

public class Cartella {
    private Casella[][] griglia;

    public Cartella() {
        griglia = new Casella[3][5];
        Random r = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int numero = r.nextInt(90) + 1;
                griglia[i][j] = new Casella(numero);
            }
        }
    }

    public void controllaNumero(int numero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (griglia[i][j].getNumero() == numero) {
                    griglia[i][j].segna();
                    System.out.println("Numero preso: "+ numero);
                }
            }
        }
    }

    public void stampa() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Casella c = griglia[i][j];
                if (c.isUscita()) {
                    System.out.print("{" + c.getNumero() + "} ");
                } else {
                    System.out.print("[" + c.getNumero() + "] ");
                }
            }
            System.out.println();
        }
    }
}
