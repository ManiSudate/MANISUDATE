package it.edu.cannizzaro.quartab25.catalogo;
public class BST<T extends Comparable<T>&Catalogabile> {
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
        System.out.println(nodo.valore.stampaEtichetta());
        visualizzaRicorsivo(nodo.destra);
    }

}