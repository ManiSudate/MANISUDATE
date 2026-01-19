import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> rubrica = new ArrayList<>();

    public void aggiungiContatto(String nome, String cognome, String numero) {
        rubrica.add(new Contatto(nome, cognome, numero));
        System.out.println("Aggiunto!");
        System.out.println();
    }

    public void rimuoviContatto(String nome, String cognome) {
        for(int i = 0; i < rubrica.size(); i++) {
            if(rubrica.get(i).getNome().equalsIgnoreCase(nome)){
                rubrica.remove(i);
                System.out.println("Rimosso!");
                System.out.println();
            }
            else{
                System.out.println("Contatto non trovato");
                System.out.println();
            }
        }
    }
    public void modificaContatto(String nome, String cognome, String numero) {
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
                contatto.setNumero(nome);
                contatto.setCognome(cognome);
                contatto.setNumero(numero);
                System.out.println("Modificato!");
                System.out.println();
            }
            else{
                System.out.println("Contatto non trovato");
                System.out.println();
            }
        }
    }
    public void cercaContatto(String nome, String cognome) {
        for (Contatto contatto : rubrica) {
            if (contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)) {
                System.out.println("Numero di "+ contatto.getNome()+" "+contatto.getCognome()+": "+contatto.getNumero());
            }
            else {
                System.out.println("Contatto non trovato");
            }
        }
        System.out.println();
    }

}
