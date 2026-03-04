package it.edu.cannizzaro.quartab25.ambulatorio;
import java.io.Serializable;

public class Prenotazione implements Serializable {
    Paziente paziente;
    Medico medico;
    String orario;
    String data;
    boolean effettuata;

    public Prenotazione(){
        this.effettuata = false;
    }
    public void setPaziente(Paziente paziente){
        this.paziente = paziente;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setOrario(String ora) {
        this.orario = ora;
    }
    public void setEffettuata(boolean effettuata){
        this.effettuata = true;
    }

    @Override
    public String toString() {
        return "Paziente: " + paziente + ", Data: " + data + ", Ora: " + orario +
                ", Effettuata: " + (effettuata ? "SI" : "NO");
    }

}
