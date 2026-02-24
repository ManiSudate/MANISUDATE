package it.edu.cannizzaro.quartab25.rubrica;
public class Contatto {
    public String nome;
    public String cognome;
    public String numero;

    public Contatto(String nome, String cognome, String numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }
    public Contatto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Contatto)) return false;
        Contatto app=(Contatto) (obj);
        if(app.getNome().equals(this.nome) && app.getCognome().equals(this.cognome)){
            return true;
        }
        return false;
    }
}
