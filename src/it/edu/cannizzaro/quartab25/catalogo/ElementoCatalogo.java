package it.edu.cannizzaro.quartab25.catalogo;
public class ElementoCatalogo implements Catalogabile, Comparable<ElementoCatalogo> {
    String codice;
    String titolo;
    String anno;
    String prezzo;

    public ElementoCatalogo(String codice, String titolo, String anno, String prezzo) {
        this.codice = codice;
        this.titolo = titolo;
        this.anno = anno;
        this.prezzo = prezzo;
    }
    

    @Override
    public int compareTo(ElementoCatalogo altro) {
        return this.codice.compareTo(altro.codice);
    }

    @Override
    public void stampaEtichetta() {
        System.out.println("Codice: "+ codice + "\n"+ "Titolo: " + titolo +"\n"+ "Anno: "+ anno + "\n"+"Prezzo: "+ prezzo+"\n");
    }
}