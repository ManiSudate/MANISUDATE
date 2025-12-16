import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Quante cartelle vuoi giocare? ");
        int numCartelle = scanner.nextInt();
        scanner.nextLine(); // consuma l'invio

        ArrayList<Cartelle> cartelle = new ArrayList<>();
        for (int i = 0; i < numCartelle; i++) {
            cartelle.add(new Cartelle());
        }

        Tabellone tabellone = new Tabellone();

        System.out.println("\nCARTELLE GIOCATORE:");
        stampaTutteCartelle(cartelle);

        while (true) {
            System.out.println("\nPremi ENTER per estrarre un numero...");
            scanner.nextLine();

            int estratto = tabellone.estraiNumero();
            System.out.println("\nNumero estratto: " + estratto);

            for (Cartelle c : cartelle) {
                c.controllaNumero(estratto);
            }

            stampaTutteCartelle(cartelle);

            // controllo vincite generiche
            for (int i = 0; i < numCartelle; i++) {
                int presi = cartelle.get(i).getNumeriPresi();
                if (presi == 2) System.out.println("AMBO sulla cartella " + (i + 1));
                if (presi == 3) System.out.println("TERNO sulla cartella " + (i + 1));
                if (presi == 4) System.out.println("QUATERNA sulla cartella " + (i + 1));
                if (presi == 5) System.out.println("CINQUINA sulla cartella " + (i + 1));
                if (presi == 15) {
                    System.out.println("TOMBOLA sulla cartella " + (i + 1) + "!");
                    scanner.close();
                    return; // termina partita
                }
            }
        }
    }

    private static void stampaTutteCartelle(ArrayList<Cartelle> cartelle) {
        // stampa tutte le cartelle una accanto all'altra
        for (int r = 0; r < 3; r++) {
            for (Cartelle c : cartelle) {
                c.stampaRiga(r);
                System.out.print("          "); // spazio tra cartelle
            }
            System.out.println();
        }
    }
}
