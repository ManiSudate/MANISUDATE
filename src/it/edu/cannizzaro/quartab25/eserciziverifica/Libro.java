public class Libro {
    String titolo;
    String autore;
    double prezzo;

    public Libro(String titolo, String autore, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    public void stampaScheda() {
        System.out.println("Titolo: " + titolo + ", Autore: " + autore + ", Prezzo: " + prezzo + "€");
    }
}