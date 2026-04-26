package it.edu.cannizzaro.quartab25.catalogo;
public class Film extends ElementoCatalogo {
    private String regista;

    public Film(String codice, String titolo, String anno, String prezzo, String regista) {
        super(codice, titolo, anno, prezzo);
        this.regista = regista;
    }

    public String getRegista() {
        return regista;
    }

    @Override
    public String stampaEtichetta() {
        return "Codice: " + getCodice() + " Titolo: " + getTitolo() + " Anno: "
                + getAnno() + " Prezzo: " + getPrezzo() + " Regista: " + regista;
    }

}