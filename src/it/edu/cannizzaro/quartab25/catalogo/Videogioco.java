package it.edu.cannizzaro.quartab25.catalogo;
public class Videogioco extends ElementoCatalogo {
    private String piattaforma;

    public Videogioco(String codice, String titolo, String anno, String prezzo, String piattaforma) {
        super(codice, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
    }

    @Override
    public void stampaEtichetta() {
        System.out.println("Codice: "+ codice + "\n"+ "Titolo: " + titolo +"\n"+ "Anno: "+ anno + "\n"+"Prezzo: "+ prezzo+"\n"+"Piattaforma: "+piattaforma+"\n");
    }

}
