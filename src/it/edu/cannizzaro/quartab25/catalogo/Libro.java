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
    public void stampaEtichetta() {
        System.out.println("Codice: "+ codice + "\n"+ "Titolo: " + titolo +"\n"+ "Anno: "+ anno + "\n"+"Prezzo: "+ prezzo+"\n"+"Autore: "+autore+"\n");
    }

}
