package it.edu.cannizzaro.quartab25.ambulatorio;
public class Prenotazione {
    Paziente paziente;
    Medico medico;
    String orario;
    String persona;
    boolean effettuata;
    String noteVisita;

    public Prenotazione(Paziente paziente, Medico medico, String orario, String persona, boolean effettuata, String noteVisita){

    }

    public void setOrario(String orario){
        this.orario = orario;
    }
    public void setPersona(String persona){
        this.persona = persona;
    }
}
