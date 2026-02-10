public class Esercizio1 {
    public static int sommaMultipliDiTre(int[] array) {
        int somma = 0;
        for (int num : array) {
            if (num % 3 == 0) {
                somma += num;
            }
        }
        return somma;
    }

    public static void main(String[] args) {
        int[] numeri = {1, 3, 6, 8, 9, 12, 15, 18, 20, 21, 24};
        System.out.println("Somma dei multipli di 3: " + sommaMultipliDiTre(numeri));
    }
}