package it.edu.cannizzaro.quartab25.rubrica;
import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> rubrica = new ArrayList<>();

    public void aggiungiContatto(String nome, String cognome, String numero, boolean isPreferito) {
        rubrica.add(new Contatto(nome, cognome, numero, isPreferito));
        System.out.println("Aggiunto!");
        System.out.println();
    }

    public void rimuoviContatto(String nome, String cognome) {
        Contatto app = new Contatto(nome, cognome);
        if(!rubrica.remove(app)){
            System.out.println("Contatto non trovato");
        }else {
            System.out.print("Contatto eliminato con successo!");
        }
        System.out.println();
    }
    public void modificaContatto(String nome, String cognome,String numero, boolean isPreferito) {
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
                contatto.setNumero(nome);
                contatto.setCognome(cognome);
                contatto.setNumero(numero);
                contatto.setPreferito(isPreferito);
                System.out.println("Modificato!");
                System.out.println();
                return;
            }
        }
        System.out.println("Contatto non trovato");
        System.out.println();
    }
    public void cercaContatto(String nome, String cognome) {
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
                System.out.println("Numero di "+ contatto.getNome()+" "+contatto.getCognome()+": "+contatto.getNumero()+contatto.getPreferito());
            }
            return;
        }
        System.out.println("Contatto non trovato");
        System.out.println();
    }
    public void mostraPreferiti(){
        for(Contatto c : rubrica){
            if(c.getPreferito()){
                System.out.println("Contatti preferiti: "+ c.getNome()+" "+c.getCognome()+" "+c.getNumero());
            }else {
                System.out.println("Non ci sono contatti preferiti");
            }

        }
    }

}
