package it.edu.cannizzaro.quartab25.persona;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Persona {
    private String nome;
    private String cognome;
    private String sesso;
    private Date dataNascita;

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

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    // Metodo per calcolare l'età
    public int calcolaEta() {

        LocalDate oggi = LocalDate.now();

        LocalDate nascita = dataNascita
                .toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(nascita, oggi).getYears();
    }

    // Metodo per stampare i dati
    public void stampaDati() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Sesso: " + sesso);
        System.out.println("Età: " + calcolaEta() + " anni");
    }
}
