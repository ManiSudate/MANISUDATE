public class ElementoCatalogo implements Catalogabile, Comparable<ElementoCatalogo> {
    private String codice;
    private String titolo;
    private String anno;
    private String prezzo;

    public ElementoCatalogo(String codice, String titolo, String anno, String prezzo) {
        this.codice = codice;
        this.titolo = titolo;
        this.anno = anno;
        this.prezzo = prezzo;
    }
    
    @Override
    public String getCodice() {
        return codice;
    }
    @Override
    public String getAnno() {
        return anno;
    }
    @Override
    public String getPrezzo() {
        return prezzo;
    }
    @Override
    public String getTitolo() {
        return titolo;
    }

    
    @Override
    public int compareTo(ElementoCatalogo altro) {
        return this.codice.compareTo(altro.codice);
    }

    @Override
    public String stampaEtichetta() {
        return "Codice: " + codice + " Titolo: " + titolo + " Anno: "
                + anno + " Prezzo: " + prezzo;
    }
}