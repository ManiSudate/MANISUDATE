package it.edu.cannizzaro.quartab25.ambulatorio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_PRENOTAZIONI = "prenotazioni.dat";
    public static void salvaPrenotazioni(List<Medico> medici) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PRENOTAZIONI))) {
            out.writeObject(new ArrayList<>(medici));
            System.out.println("Prenotazioni salvate!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Medico> caricaPrenotazioni() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PRENOTAZIONI))) {
            return (ArrayList<Medico>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Medico> medici = caricaPrenotazioni();

        if (medici.isEmpty()) {
            medici.add(new Medico("Younan", "Nowzaradan", "Chirurgia vascolare"));
            medici.add(new Medico("Umberto", "Veronesi", "Oncologo"));
            medici.add(new Medico("Anthony", "Fauci", "Malattie infettive"));
            salvaPrenotazioni(medici);
        }
        int scelta;
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
                    String continua1;
                    do {
                        Paziente p = new Paziente();

                        System.out.print("Nome paziente: ");
                        p.setNome(s.nextLine());

                        System.out.print("Cognome paziente: ");
                        p.setCognome(s.nextLine());

                        System.out.print("Sesso: ");
                        p.setSesso(s.nextLine());

                        System.out.print("Data di nascita: ");
                        p.setDataNascita(s.nextLine());

                        System.out.println("\nScegli il medico:");
                        for (int i = 0; i < medici.size(); i++) {
                            System.out.println((i + 1) + ") " +
                                    medici.get(i).getName() + " - " +
                                    medici.get(i).getSpecializzazione());
                        }

                        System.out.print("Numero: ");
                        int sceltamedico = s.nextInt();
                        s.nextLine();

                        if (sceltamedico < 1 || sceltamedico > medici.size()) {
                            System.out.println("Medico non valido.");
                            break;
                        }

                        Medico medicoscelto = medici.get(sceltamedico - 1);

                        Prenotazione prenotazione = new Prenotazione();
                        prenotazione.setPaziente(p);
                        prenotazione.setMedico(medicoscelto);

                        System.out.print("Data visita: ");
                        prenotazione.setData(s.nextLine());

                        System.out.print("Orario visita: ");
                        prenotazione.setOrario(s.nextLine());

                        medicoscelto.aggiungiPrenotazione(prenotazione);

                        salvaPrenotazioni(medici);

                        System.out.println("Prenotazione aggiunta e salvata!");

                        System.out.print("Vuoi inserire un altro appuntamento? (s/n): ");
                        continua1 = s.nextLine();

                    } while (continua1.equalsIgnoreCase("s"));
                    break;

                case 2:
                    String continua2;
                    do {
                        System.out.println("\nChi sei?");
                        for (int i = 0; i < medici.size(); i++) {
                            System.out.println((i + 1) + ") " +
                                    medici.get(i).getName());
                        }

                        System.out.print("Numero: ");
                        int idmedico = s.nextInt();
                        s.nextLine();

                        if (idmedico < 1 || idmedico > medici.size()) {
                            System.out.println("Medico non valido.");
                            break;
                        }

                        Medico medico = medici.get(idmedico - 1);

                        System.out.println("\nPrenotazioni in coda:");
                        medico.visualizzaPrenotazioni();

                        System.out.print("Effettuare la prossima visita? (s/n): ");
                        String risposta = s.nextLine();

                        if (risposta.equalsIgnoreCase("s")) {
                            Prenotazione visita = medico.prossimaVisita();
                            if (visita != null) {
                                visita.setEffettuata(true);
                                System.out.println("Visita completata.");
                                salvaPrenotazioni(medici);
                            } else {
                                System.out.println("Nessuna prenotazione.");
                            }
                        }

                        System.out.print("Vuoi continuare? (s/n): ");
                        continua2 = s.nextLine();

                    } while (continua2.equalsIgnoreCase("s"));
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }
}