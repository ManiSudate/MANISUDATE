package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;

import java.time.LocalDate;

public class Paziente extends Persona {
    String motivoVisita;

    public void Paziente(String nome, String cognome, String sesso, LocalDate dataNascita, String motivoVisita){
        this.motivoVisita = motivoVisita;
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
