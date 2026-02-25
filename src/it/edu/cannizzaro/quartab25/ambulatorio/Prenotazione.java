package it.edu.cannizzaro.quartab25.ambulatorio;
public class Prenotazione {
    Paziente paziente;
    Medico medico;
    String orario;
    String data;
    boolean effettuata;
    String note;


    public Prenotazione(){
        this.effettuata = false;
        this.note = "";
    }

    public void setPaziente(Paziente paziente){
        this.paziente = paziente;
    }
    public Paziente getPaziente() {
        return paziente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Medico getMedico() {
        return medico;
    }


    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }


    public String getOrario() {
        return orario;
    }

    public void setOrario(String ora) {
        this.orario = ora;
    }



    public boolean isEffettuata() {
        return effettuata;
    }
    public void setEffettuata(boolean effettuata){
        this.effettuata = true;
    }


    public void setNote(String note) {
        this.note = note;
    }
    public String getNote(){
        return note;
    }



    @Override
    public String toString() {
        return "Paziente: " + paziente +
                ", Data: " + data +
                ", Ora: " + orario +
                ", Effettuata: " + (effettuata ? "SI" : "NO") +
                (note.isEmpty() ? "" : ", Note: " + note);
    }

}
