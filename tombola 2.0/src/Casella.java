public class Casella {
    private int numero;

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