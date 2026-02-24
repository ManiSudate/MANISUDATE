package it.edu.cannizzaro.quartab25.giorno;
import java.time.LocalDate;

public class Giorno {
    public static void main(String[] args) {
        LocalDate dataOdierna = LocalDate.now();
        System.out.println("Benvenuto! Oggi è: " + dataOdierna);
    }
}