package it.edu.cannizzaro.quartab25.catalogo;
public class Libro extends ElementoCatalogo {
    private String autore;

    public Libro(String codice, String titolo, String anno, String prezzo, String autore) {
        super(codice, titolo, anno, prezzo);
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }

    @Override
    public String stampaEtichetta() {
        return "Codice: " + getCodice() + " Titolo: " + getTitolo() + " Anno: "
                + getAnno() + " Prezzo: " + getPrezzo() + " Autore: " + autore;
    }

}
