package it.edu.cannizzaro.quartab25.ambulatorio;
import java.io.Serializable;
import java.util.ArrayList;

public class Coda <t> implements Serializable {

    private ArrayList<t> lista = new ArrayList<>();

    public Coda(){}

    public t getPrimoFila(){
        t s = lista.getFirst();
        lista.remove(s);
        return s;
    }
    public void aggiungiCoda(t nuovo){
        lista.add(nuovo);
    }
    public void stampa(){
        for (t obj : lista){
            System.out.println(" "+ obj+" ");
        }
    }
}

