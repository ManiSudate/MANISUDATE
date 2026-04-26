package it.edu.cannizzaro.quartab25.catalogo;
public class Videogioco extends ElementoCatalogo {
    private String piattaforma;

    public Videogioco(String codice, String titolo, String anno, String prezzo, String piattaforma) {
        super(codice, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    @Override
    public String stampaEtichetta() {
        return "Codice: " + getCodice() + " Titolo: " + getTitolo() + " Anno: "
                + getAnno() + " Prezzo: " + getPrezzo() + " Piattaforma: " + piattaforma;
    }

}
