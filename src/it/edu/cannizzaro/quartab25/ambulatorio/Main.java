package it.edu.cannizzaro.quartab25.ambulatorio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);

        Medico m1 = new Medico("Younan", "Nowzaradan", "Chirurgia vascolare");
        Medico m2 = new Medico("Umberto", "Veronesi", "Oncologo");
        Medico m3 = new Medico("Anthony", "Fauci", "Malattie infettive");

        int scelta;
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String data;


        do {
            System.out.println("\n--- POLIAMBULATORIO ---");
            System.out.println("1) Segreteria");
            System.out.println("2) Medico");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");
            scelta = s.nextInt();
            s.nextLine();

            switch (scelta) {
                case 1:
                    Paziente p = new Paziente();
                    System.out.print("Nome paziente: ");
                    p.setNome(s.nextLine());

                    System.out.print("Cognome paziente: ");
                    p.setCognome(s.nextLine());

                    System.out.print("Sesso: ");
                    p.setSesso(s.nextLine());

                    System.out.print("Data di nascita: ");
                    data = s.nextLine();
                    p.setDataNascita(sd.parse(data));

                    System.out.println("1) " + m1.getNome() + " - " + m1.getSpecializzazione());
                    System.out.println("2) " + m2.getNome() + " - " + m2.getSpecializzazione());
                    System.out.println("3) " + m3.getNome() + " - " + m3.getSpecializzazione());
                    System.out.print("Scegli il medico: ");
                    int sceltamedico = s.nextInt();
                    s.nextLine();

                    Medico medicoscelto = null;

                    if (sceltamedico == 1) medicoscelto = m1;
                    if (sceltamedico == 2) medicoscelto = m2;
                    if (sceltamedico == 3) medicoscelto = m3;

                    Prenotazione prenotazione = new Prenotazione();

                    prenotazione.setPaziente(p);
                    prenotazione.setMedico(medicoscelto);

                    System.out.print("Data: ");
                    prenotazione.setData(s.nextLine());

                    System.out.print("Orario: ");
                    prenotazione.setOrario(s.nextLine());

                    medicoscelto.aggiungiPrenotazione(prenotazione);

                    System.out.println("Prenotazione aggiunta!");
                    break;



            }
        }while (scelta != 0);
    }
}


