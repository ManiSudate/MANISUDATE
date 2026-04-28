package it.edu.cannizzaro.quartab25.catalogo;
import java.io.*;

public class BST<T extends Comparable<T> & Catalogabile & ToCSV> {
    private class Nodo<T> {
        T valore;
        Nodo<T> destra, sinistra;

        Nodo(T valore) {
            this.valore = valore;
            this.destra = null;
            this.sinistra = null;
        }
    }

    private Nodo<T> radice;

    public void inserisci(T valore) {
        this.radice = inserisciRicorsivo(radice, valore);
    }

    private Nodo<T> inserisciRicorsivo(Nodo<T> nodo, T valore) {
        if (nodo == null) {
            return new Nodo<T>(valore);
        }
        int confronto = valore.compareTo(nodo.valore);
        if (confronto == 0) {
            return nodo;
        } else if (confronto < 0) {
            nodo.sinistra = inserisciRicorsivo(nodo.sinistra, valore);
        } else {
            nodo.destra = inserisciRicorsivo(nodo.destra, valore);
        }
        return nodo;
    }

    public T cerca(T valore) {
        return cercaRicorsivo(radice, valore);
    }

    private T cercaRicorsivo(Nodo<T> nodo, T valore) {
        if (nodo == null) {
            return null;
        }
        int confronto = valore.compareTo(nodo.valore);
        if (confronto == 0) {
            return nodo.valore;
        } else if (confronto < 0) {
            return cercaRicorsivo(nodo.sinistra, valore);
        } else {
            return cercaRicorsivo(nodo.destra, valore);
        }
    }

    public boolean elimina(T valore) {
        return eliminaRicorsivo(radice, valore);
    }

    private boolean eliminaRicorsivo(Nodo<T> nodo, T valore) {
        if (nodo == null) {
            return false;
        }
        int confronto = valore.compareTo(nodo.valore);
        if (confronto == 0) {
            return true;
        } else if (confronto < 0) {
            return eliminaRicorsivo(nodo.sinistra, valore);
        } else {
            return eliminaRicorsivo(nodo.destra, valore);
        }
    }

    public void visualizza() {
        visualizzaRicorsivo(radice);
    }

    private void visualizzaRicorsivo(Nodo<T> nodo) {
        if (nodo == null) {
            return;
        }
        visualizzaRicorsivo(nodo.sinistra);
        nodo.valore.stampaEtichetta();
        visualizzaRicorsivo(nodo.destra);
    }

    public void caricaCSV(){
        try {
            FileReader f= new FileReader("catalogo.CSV");
            BufferedReader fIN=new BufferedReader(f);

            String s;
            s=fIN.readLine();
            int i = 0;
            while(s!=null){
                String[] splitArray =s.split(",");
                for(String string:splitArray){
                    splitArray[i++]=string.replace("\"","").trim();
                }
                String tipo = splitArray[0];
                switch (tipo){
                    case "Libro":
                        Libro libro= new Libro(splitArray[1],splitArray[2],splitArray[3],splitArray[4],splitArray[5]);
                        inserisci((T) libro);
                        break;
                    case "Film":
                        Film film= new Film(splitArray[1],splitArray[2],splitArray[3],splitArray[4],splitArray[5]);
                        inserisci((T) film);
                        break;
                    case "Videogioco":
                        Videogioco videogioco = new Videogioco(splitArray[1],splitArray[2],splitArray[3],splitArray[4],splitArray[5]);
                        inserisci((T) videogioco);
                        break;
                    default:
                        break;
                }

                s=fIN.readLine();
                i = 0;
            }
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void salvaCSV(String nomeFile) {
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            writer.write("\"tipo\", \"titolo\", \"anno di pubblicazione\", \"id\", \"autore/produttore/regista\"");
            salvaCSVRicorsivo(radice, writer);
            
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }

    private void salvaCSVRicorsivo(Nodo<T> nodo, PrintWriter writer) {
        if (nodo == null) {
            return;
        }
        salvaCSVRicorsivo(nodo.sinistra, writer);
        writer.println(nodo.valore.printCSV());
        salvaCSVRicorsivo(nodo.destra, writer);
    }

}