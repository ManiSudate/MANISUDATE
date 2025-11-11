import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Inserisci il raggio del primo cerchio: ");
        double raggio1 = scanner.nextDouble();

        System.out.print("Inserisci il raggio del secondo cerchio: ");
        double raggio2 = scanner.nextDouble();


        double circonferenza1 = 2 * Math.PI * raggio1;
        double circonferenza2 = 2 * Math.PI * raggio2;


        System.out.println("La circonferenza del primo cerchio è: " + circonferenza1);
        System.out.println("La circonferenza del secondo cerchio è: " + circonferenza2);


        if (circonferenza1 > circonferenza2) {
            System.out.println("Il primo cerchio ha la circonferenza più grande.");
        } else if (circonferenza1 < circonferenza2) {
            System.out.println("Il secondo cerchio ha la circonferenza più grande.");
        } else {
            System.out.println("I due cerchi hanno la stessa circonferenza.");
        }


        scanner.close();
    }
}
