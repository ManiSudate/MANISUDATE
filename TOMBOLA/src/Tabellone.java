import java.util.ArrayList;
import java.util.Random;

public class Tabellone {

    private ArrayList<Integer> numeri;
    private Random random;

    public Tabellone() {
        numeri = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numeri.add(i);
        }
        random = new Random();
    }

    public int estraiNumero() {
        int index = random.nextInt(numeri.size());
        return numeri.remove(index);
    }
}
