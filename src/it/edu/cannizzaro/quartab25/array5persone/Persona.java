import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String sesso;

    public Persona(String nome, String cognome, LocalDate dataDiNascita, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getSesso() {
        return sesso;
    }

    public int getEta() {
        return Period.between(dataDiNascita, LocalDate.now()).getYears();
    }
}
