class Motocicletta extends Bicicletta {
    String marca;
    double consumoMedio;

    Motocicletta(String marca, String colore, int numeroMarce, double peso, double consumoMedio) {
        super(colore, numeroMarce, peso);
        this.marca = marca;
        this.consumoMedio = consumoMedio;
    }

    void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    double calcolaConsumo(double km) {
        return km / consumoMedio;
    }
}
