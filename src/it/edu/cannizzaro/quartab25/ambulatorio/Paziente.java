package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;

import java.time.LocalDate;
import java.util.Date;

public class Paziente extends Persona {
    String nome;
    String cognome;
    String sesso;
    Date dataNascita;

    public Paziente(){
        setNome(nome);
        setCognome(cognome);
        setSesso(sesso);
        setDataNascita(dataNascita);
    }
    @Override
    public String toString() {
        return getNome();
    }
}
