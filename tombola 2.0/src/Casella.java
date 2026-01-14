public class Casella {
    private int numero;
    private boolean uscita;
    private static final String ROSSO = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public Casella(int numero) {
        if (numero >= 0) {
            this.numero = numero;
        } else try {
            throw new Exception("SOLO POSITIVI");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.uscita = false;
    }

    public int getNumero() {
        return numero;
    }

    public void segna() {
        uscita = true;
    }

    @Override
    public String toString() {
        if (numero == 0) {
            return " ";
        }
        if (uscita) {
            return ROSSO + numero + RESET;
        }
        return String.valueOf(numero);
    }
}