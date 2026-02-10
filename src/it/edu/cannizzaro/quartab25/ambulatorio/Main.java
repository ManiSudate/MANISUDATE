package it.edu.cannizzaro.quartab25.ambulatorio;
import it.edu.cannizzaro.quartab25.persona.Persona;
import java.time.LocalDate;

public class Main {
    public static void main(String [] args){
        Persona p = new Persona();
        p.setNome("Fil");
        p.setCognome("Lic");
        p.setSesso("Mas");
        p.setDataNascita(LocalDate.of(2009, 1, 8));
        p.stampaDati();
    }
}
