import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tabellone tabellone = new Tabellone();
        Cartella cartella = new Cartella();
        Scanner s = new Scanner(System.in);

        System.out.println("Cartella iniziale:");
        cartella.stampaCartella();

        while (true) {
            System.out.println("\nPremi INVIO per estrarre un numero");
            s.nextLine();

            int numero = tabellone.estraiNumero();
            System.out.println("Estratto: " + numero);

            cartella.controllaNumero(numero);
            cartella.stampaCartella();
        }
    }
}
