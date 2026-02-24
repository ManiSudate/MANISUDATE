package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;

import java.util.Queue;

public class Medico extends Persona {
    String specializzazione;
    boolean effettuata;

    Queue<Paziente> listaPrenotazioni;

    public Medico(String nome, String cognome, String specializzazione){
        this.specializzazione = specializzazione;
        super(nome,cognome);
    }
    public String getNome(){
        return nome;
    }
    public String getFullName(){
        return nome+" "+cognome;
    }
    public String getSpecializzazione(){
        return specializzazione;
    }


    public void aggiungiPrenotazione(Prenotazione p){
    }

    public void vediPrenotazioni(){
    }

    public void setEffettuata(boolean effettuata){
        this.effettuata = true;
    }

}
