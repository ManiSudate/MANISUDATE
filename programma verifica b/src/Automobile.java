class Automobile extends Carro {
    String marca;
    double consumoMedio;

    Automobile(String marca, String colore, double peso, double consumoMedio) {
        super(colore, peso);
        this.marca = marca;
        this.consumoMedio = consumoMedio;
    }

    void setMarca(String marca) {
        this.marca = marca;
    }

    void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    double calcolaConsumo(double km) {
        return km / consumoMedio;
    }
}
