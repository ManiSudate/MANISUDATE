package it.edu.cannizzaro.quartab25.persona;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input utente
        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("Inserisci il sesso (M/F): ");
        String sesso = scanner.nextLine();

        System.out.print("Inserisci la data di nascita (formato YYYY-MM-DD): ");
        String dataNascitaStr = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(dataNascitaStr);

        Date dataNascita = Date.from(
                localDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()
        );


        Persona persona = new Persona();
        persona.setNome(nome);
        persona.setCognome(cognome);
        persona.setSesso(sesso);
        persona.setDataNascita(dataNascita);

        // Stampa i dati
        System.out.println("\n--- Dati Inseriti ---");
        persona.stampaDati();

        scanner.close();
    }
}
