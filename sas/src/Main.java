import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        System.out.println("Chi sei?");

        Scanner s = new Scanner(System.in);

        System.out.print("Inserisci nome: ");
        String nome = s.nextLine();

        System.out.print("Inserisci cognome: ");
        String cognome = s.nextLine();

        Persona p = new Persona(nome, cognome);

        p.stampaDati();


    }
}
