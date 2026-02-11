package it.edu.cannizzaro.quartab25.persona;
import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nome;
    private String cognome;
    private String sesso;
    private LocalDate dataNascita;

    // Metodi setter
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

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    // Metodo per calcolare l'età
    public int calcolaEta() {
        LocalDate oggi = LocalDate.now();
        return Period.between(dataNascita, oggi).getYears();
    }

    // Metodo per stampare i dati
    public void stampaDati() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Sesso: " + sesso);
        System.out.println("Età: " + calcolaEta() + " anni");
    }
}
