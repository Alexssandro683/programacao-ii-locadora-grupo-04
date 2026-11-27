package model;

public abstract class Quadriciclo extends Veiculo {

    public Quadriciclo(String placa, String modelo, double valorDiaria) {
        super(placa, modelo, valorDiaria);
    }

    @Override
    public String getTipo() {
        return "QUADRICICLO";
    }
}