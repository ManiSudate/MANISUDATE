public class Main {
    public static void main(String [] args){
        Cerchio cerchio1 = null;
        cerchio1 = new Cerchio();

        cerchio1.setRaggio(5);

        System.out.println("L'area del cerchio raggio 5 è: "+cerchio1.calcArea());
    }
}
