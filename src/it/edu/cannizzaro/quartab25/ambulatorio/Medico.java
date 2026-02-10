package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;

import java.time.LocalDate;

public class Medico extends Persona {


    public Medico(String nome , String cognome, String sesso, LocalDate dataNascita){
        setNome(nome);
        setCognome(cognome);
        setSesso(sesso);
        setDataNascita(dataNascita);
    }
}
