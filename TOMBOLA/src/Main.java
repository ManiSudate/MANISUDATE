import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Quante cartelle vuoi giocare? ");
        int numCartelle = scanner.nextInt();
        scanner.nextLine();

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
            for (int i = 0; i < cartelle.size(); i++) {

                Cartelle c = cartelle.get(i);

                for (int r = 0; r < 3; r++) {

                    int presiRiga = c.numeriSegnatiInRiga(r);

                    if (presiRiga == 2 && !c.isAmboFatto(r)) {
                        System.out.println("AMBO sulla cartella " + (i + 1) + " riga " + (r + 1));
                        c.setAmboFatto(r);
                    }

                    if (presiRiga == 3 && !c.isTernoFatto(r)) {
                        System.out.println("TERNO sulla cartella " + (i + 1) + " riga " + (r + 1));
                        c.setTernoFatto(r);
                    }

                    if (presiRiga == 4 && !c.isQuaternaFatto(r)) {
                        System.out.println("QUATERNA sulla cartella " + (i + 1) + " riga " + (r + 1));
                        c.setQuaternaFatto(r);
                    }

                    if (presiRiga == 5 && !c.isCinquinaFatto(r)) {
                        System.out.println("CINQUINA sulla cartella " + (i + 1) + " riga " + (r + 1));
                        c.setCinquinaFatto(r);
                    }

                }

                if (c.isTombola()) {
                    System.out.println("TOMBOLA sulla cartella " + (i + 1));
                    return;
                }
            }



        }
    }

    private static void stampaTutteCartelle(ArrayList<Cartelle> cartelle) {
        for (int r = 0; r < 3; r++) {
            for (Cartelle c : cartelle) {
                c.stampaRiga(r);
                System.out.print("          ");
            }
            System.out.println();
        }
    }
}
