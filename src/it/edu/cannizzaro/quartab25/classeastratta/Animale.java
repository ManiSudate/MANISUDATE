// Classe astratta
public abstract class Animale {
    public abstract void emettiSuono(); // metodo astratto

    public void dormi() { // metodo concreto
        System.out.println("Zzz...");
    }
}