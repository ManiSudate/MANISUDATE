public class Esercizio3 {
    public static double prezzoMedio(Libro[] libri) {
        double somma = 0;
        for (Libro l : libri) {
            somma += l.prezzo;
        }
        return somma / libri.length;
    }

    public static void main(String[] args) {
        Libro[] libri =
                {
                new Libro("I promessi sposi", "Manzoni", 10.0),
                new Libro("La Divina Commedia", "Dante", 14.0)
        };

        for (Libro l : libri) {
            l.stampaScheda();
        }

        System.out.println("Prezzo medio: " + prezzoMedio(libri) + "€");
    }
}