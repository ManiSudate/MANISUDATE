public class Rettangolo {

    public static void main(String[] args) {
        Rettangolo r1 = new Rettangolo(5.0, 3.0);
        r1.stampaInfo();
    }

    double base;
    double altezza;

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return base * altezza;
    }

    public double calcolaPerimetro() {
        return 2 * (base + altezza);
    }

    public void stampaInfo() {
        System.out.println("Base: " + base);
        System.out.println("Altezza: " + altezza);
        System.out.println("Area: " + calcolaArea());
        System.out.println("Perimetro: " + calcolaPerimetro());
    }
}
