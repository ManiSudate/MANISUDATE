package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;
import java.time.LocalDate;
import java.util.ArrayList;

public class Medico extends Persona {
    String specializzazione;
    Coda<Paziente> listaPrenotazioni = new Coda<>();

    public Medico(String nome, String cognome, String specializzazione){
        setNome(nome);
        setCognome(cognome);
        this.specializzazione = specializzazione;
    }

    public void segnaVisitaEffettuata(Prenotazione p, String note){

    }

}
