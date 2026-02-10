package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;

public class Paziente extends Persona {
    String motivoVisita;

    public void Paziente(String nome, String cognome, String sesso, String dataNascita,String motivoVisita){
        this.motivoVisita = motivoVisita;
    }


}
