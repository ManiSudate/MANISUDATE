public class Cubo extends Quadrato {

    public Cubo(double lato) {
        super(lato);
    }


    public double volume() {
        return lato * lato * lato;
    }

    public String toString() {
        return "Cubo [lato=" + lato + "]";
    }
}
