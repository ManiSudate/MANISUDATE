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
    public void stampaEtichetta() {
        System.out.println("Codice: "+ codice + "\n"+ "Titolo: " + titolo +"\n"+ "Anno: "+ anno + "\n"+"Prezzo: "+ prezzo+"\n"+"Regista: "+regista+"\n");
    }

    @Override
    public String printCSV() {
        return super.printCSV() + ", \"" + regista + "\"";
    }
}