package it.edu.cannizzaro.quartab25.ambulatorio;


import java.io.Serializable;

public class Paziente implements Serializable {
    String nome;
    String cognome;
    String sesso;
    String dataNascita;

    public Paziente(){
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome(){
        return "Nome: "+nome+"Cognome: "+cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + ", Sesso: " + sesso + ", Data di nascita: " + dataNascita;
    }
}
