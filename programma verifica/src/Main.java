public class Main {
    public static void main(String[] args) {
        Motocicletta moto = new Motocicletta("Yamaha", "Nera", 6, 180, 20);

        double km = 100;
        double litri = moto.calcolaConsumo(km);

        System.out.println("Per percorrere " + km + " km servono " + litri + " litri di carburante.");
    }
}
