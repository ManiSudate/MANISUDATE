public class Casella {
    private int numero;
    private boolean uscito;

    public void setNumero(int numero){
        if(numero > 0) {
            this.numero = numero;
        }
        else try {
            throw new Exception("SOLO NUMERI POSITIVI");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}