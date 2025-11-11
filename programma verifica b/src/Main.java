public class Main {
    public static void main(String[] args) {
        Automobile auto = new Automobile("Fiat", "Rosso", 1200, 18);

        auto.setMarca("Fiat Panda");
        auto.setConsumoMedio(20);

        double km = 100;
        double litri = auto.calcolaConsumo(km);

        System.out.println("\nPer percorrere " + km + " km servono " + litri + " litri di carburante.");
    }
}
