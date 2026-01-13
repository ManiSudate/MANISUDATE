public class Casella {
    private int numero;
    private boolean uscita;

    public Casella(int numero) {
        if(numero > 0) {
            this.numero = numero;
        }
        else try {
            throw new Exception("SOLO NUMERI POSITIVI");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.uscita = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isUscita() {
        return uscita;
    }

    public void segna() {
        uscita = true;
    }
}
