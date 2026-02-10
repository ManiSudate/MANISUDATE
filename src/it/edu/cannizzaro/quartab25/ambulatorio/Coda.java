package it.edu.cannizzaro.quartab25.ambulatorio;
import java.util.ArrayList;
import java.util.List;

public class Coda <t>{
    List<t> lista = new ArrayList<>() {
    };

    public void add(Object obj){
        lista.add((t) obj);
    }

    public void stampa(){
        for(t t:lista){
            System.out.print(t);
        }
    }
}

