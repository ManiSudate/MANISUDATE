package it.edu.cannizzaro.quartab25.ambulatorio;
import java.util.ArrayList;

public class Coda <t>{
    private ArrayList<t> lista = new ArrayList<>();

    public Coda(ArrayList<t>lista){
        this.lista = lista;
    }

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
        int i=0;
        for (t obj : lista){
            i++;
            System.out.println(" "+ obj+i);
        }
    }
}

