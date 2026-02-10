import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Inserisci dati della prima persona ===");
        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();

        System.out.print("Cognome: ");
        String cognome1 = scanner.nextLine();

        System.out.print("Sesso (M/F): ");
        String sesso1 = scanner.nextLine();

        System.out.print("Classe: ");
        String classe = scanner.nextLine();

        System.out.print("Media: ");
        String media = scanner.nextLine();

        Persona persona1 = new Persona(nome1, cognome1, sesso1);



        System.out.println("\n=== Inserisci dati della seconda persona ===");
        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();

        System.out.print("Cognome: ");
        String cognome2 = scanner.nextLine();

        System.out.print("Sesso (M/F): ");
        String sesso2 = scanner.nextLine();

        System.out.print("Classe: ");
        String classe2 = scanner.nextLine();

        System.out.print("Media: ");
        String media2 = scanner.nextLine();

        Persona persona2 = new Persona(nome2, cognome2, sesso2);


        System.out.println("\n--- Dati Prima Persona ---");
        System.out.println(persona1.toString());

        System.out.println("\n--- Dati Seconda Persona ---");
        System.out.println(persona2.toString());

        System.out.println("\nRisultato del confronto:");
        if (persona1.equals(persona2)) {
            System.out.println("Le due persone sono UGUALI.");
        } else {
            System.out.println("Le due persone sono DIVERSE.");
        }

    }
}
