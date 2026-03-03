package it.edu.cannizzaro.quartab25.ambulatorio;

import java.io.Serializable;

public class Medico implements Serializable {
    String specializzazione;
    String nome;
    String cognome;

    private Coda<Prenotazione> prenotazioni = new Coda<>();

    public Medico(String nome, String cognome, String specializzazione){
        this.specializzazione = specializzazione;
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getName(){
        return nome+" "+cognome;
    }
    public String getSpecializzazione(){
        return specializzazione;
    }
    public void aggiungiPrenotazione(Prenotazione p) {
        prenotazioni.aggiungiCoda(p);
    }
    public Prenotazione prossimaVisita() {
        return prenotazioni.getPrimoFila();
    }

    public void visualizzaPrenotazioni() {
        prenotazioni.stampa();
    }

}
