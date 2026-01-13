import java.util.ArrayList;
import java.util.Random;

public class Tabellone {
    private ArrayList<Integer> numeri;

    public Tabellone() {
        numeri = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numeri.add(i);
        }
    }

    public int estraiNumero() {
        Random r = new Random();
        int index = r.nextInt(numeri.size());
        return numeri.remove(index);
    }
}
