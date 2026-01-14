import java.util.ArrayList;
import java.util.Collections;

public class Tabellone {
    private ArrayList<Integer> numeri;

    public Tabellone() {
        numeri = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numeri.add(i);
        }
        Collections.shuffle(numeri);
    }
    public int estraiNumero() {
        return numeri.removeFirst();
    }
}