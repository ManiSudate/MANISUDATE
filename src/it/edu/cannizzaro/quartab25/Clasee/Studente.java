public class Studente extends Persona {
    String classe;
    String media;

    public Studente(String nome, String cognome, String sesso, String classe, String media) {
        super(nome, cognome, sesso);
        this.classe = classe;
        this.media = media;
    }

    @Override
    public String toString() {
        return super.toString() + ", Classe: " + classe + ", Media: " + media;
    }

    public void stampaDati() {
        System.out.println(toString());
    }
}
