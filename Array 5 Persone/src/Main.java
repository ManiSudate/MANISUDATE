import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Persona[] persone = new Persona[5];

        persone[0] = new Persona("Mario", "Rossi", LocalDate.of(1980, 5, 15), "M");
        persone[1] = new Persona("Luisa", "Bianchi", LocalDate.of(1975, 8, 20), "F");
        persone[2] = new Persona("Giovanni", "Verdi", LocalDate.of(1990, 12, 1), "M");
        persone[3] = new Persona("Anna", "Neri", LocalDate.of(1985, 3, 10), "F");
        persone[4] = new Persona("Paolo", "Gialli", LocalDate.of(1978, 6, 30), "M");

        Persona piuAnziana = persone[0];

        for (int i = 1; i < persone.length; i++) {
            if (persone[i].getDataDiNascita().isBefore(piuAnziana.getDataDiNascita())) {
                piuAnziana = persone[i];
            }
        }

        System.out.println("La persona più anziana è:");
        System.out.println("Nome: " + piuAnziana.getNome());
        System.out.println("Cognome: " + piuAnziana.getCognome());
        System.out.println("Sesso: " + piuAnziana.getSesso());
        System.out.println("Età: " + piuAnziana.getEta() + " anni");
    }
}