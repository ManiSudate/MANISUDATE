import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tabellone tabellone = new Tabellone();
        Cartella cartella = new Cartella();
        Scanner s = new Scanner(System.in);

        System.out.println("Cartella iniziale:");
        cartella.stampa();

        while (true) {
            System.out.println("Clicca Enter per estrarre un numero...");
            s.nextLine();
            int numero = tabellone.estraiNumero();
            System.out.println("\nEstratto: " + numero);

            cartella.controllaNumero(numero);
            cartella.stampa();
        }
    }
}
