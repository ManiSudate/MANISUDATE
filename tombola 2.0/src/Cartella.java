import java.util.Enumeration;
import java.util.Random;

public class Cartella {
   private Casella[][] cartella;

   public Cartella() {
       cartella = new Casella[3][5];
       Random r = new Random();
       for (int i = 0; i < 3; i++){
           for (int j = 0; j < 5; j++){
               int x = r.nextInt(90);
               cartella[i][j] = new Casella(x);
           }
       }
   }
    public void controllaNumero(int numero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (cartella[i][j].getNumero() == numero) {
                    cartella[i][j].segna();
                }
            }
        }
    }

   public void stampaCartella(){
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 5; j++) {
               Casella c = cartella[i][j];
               if(c.isUscita()){
                   System.out.println(" [ "+ c.getNumero() + " ] ");
               }
               else  {
                   System.out.print(" [ "+ c.getNumero() + " ] ");
               }
           }
           System.out.println();
       }
   }
}
