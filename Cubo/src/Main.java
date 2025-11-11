public class Main {
    public static void main(String[] args) {

        Cubo c = new Cubo(3);
        System.out.println("\n" + c);
        System.out.println("Volume Cubo: " + c.volume());


        Parallelepipedo p = new Parallelepipedo(3, 4, 5);
        System.out.println("\n" + p);
        System.out.println("Volume Parallelepipedo: " + p.volume());
    }
}
