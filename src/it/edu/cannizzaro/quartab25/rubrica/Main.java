package it.edu.cannizzaro.quartab25.rubrica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();
        int scelta;

        do {
            System.out.println("-------RUBRICA-------");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Modifica contatto");
            System.out.println("3. Elimina contatto");
            System.out.println("4. Cerca contatto");
            System.out.println("5. Mostra Preferiti");
            System.out.println("0. Esci");
            System.out.print("Selezione: ");
            scelta = s.nextInt();
            s.nextLine();
            switch (scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = s.nextLine();
                    System.out.print("Cognome: ");
                    String cognome = s.nextLine();
                    System.out.print("Numero: ");
                    String numero = s.nextLine();
                    System.out.print("Aggiungere ai preferiti?(si/no): ");
                    String sc = s.nextLine();
                    boolean isPreferito;
                    if( sc.equalsIgnoreCase("si")){
                        isPreferito = true;
                        rubrica.aggiungiContatto(nome, cognome, numero, isPreferito);
                    }else {
                        isPreferito = false;
                        rubrica.aggiungiContatto(nome, cognome, numero, isPreferito);
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    nome = s.nextLine();
                    System.out.print("Cognome: ");
                    cognome = s.nextLine();
                    System.out.print("Inserisci il nuovo numero: ");
                    numero = s.nextLine();
                    System.out.print("Aggiungere ai preferiti?(si/no): ");
                    sc = s.nextLine();
                    if( sc.equalsIgnoreCase("si")){
                        isPreferito = true;
                        rubrica.aggiungiContatto(nome, cognome, numero, isPreferito);
                    }else {
                        isPreferito = false;
                        rubrica.aggiungiContatto(nome, cognome, numero, isPreferito);
                    }
                    rubrica.modificaContatto(nome, cognome, numero, isPreferito);
                    break;
                case 3:
                    System.out.print("Nome: ");
                    nome = s.nextLine();
                    System.out.print("Cognome: ");
                    cognome = s.nextLine();
                    rubrica.rimuoviContatto(nome, cognome);
                    break;
                case 4:
                    System.out.print("Nome: ");
                    nome = s.nextLine();
                    System.out.print("Cognome: ");
                    cognome = s.nextLine();
                    rubrica.cercaContatto(nome,cognome);
                    break;
                case 5:
                    rubrica.mostraPreferiti();
            }
        } while (scelta != 0);
    }
}