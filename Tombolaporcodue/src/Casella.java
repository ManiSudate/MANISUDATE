public class Casella {
    private int numero;
    private boolean uscita;

    private static final String ROSSO = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public Casella(int numero) {
        if(numero >= 0) {
            this.numero = numero;
        }
        else try {
            throw new Exception("SOLO POSITIVI");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.uscita = false;
    }
    @Override
    public String toString() {

        if (numero == 0) {
            return "  ";
        }

        String n = String.format("%2d", numero);

        if (uscita) {
            return ROSSO + n + RESET;
        }
        return n;
    }


    public int getNumero() {
        return numero;
    }

    public void segna() {
        uscita = true;
    }
}
