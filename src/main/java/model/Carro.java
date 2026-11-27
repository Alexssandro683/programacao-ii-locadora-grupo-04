package model;

public abstract class Carro extends Veiculo {

    public Carro(String placa, String modelo, double valorDiaria) {
        super(placa, modelo, valorDiaria);
    }

    @Override
    public String getTipo() {
        return "CARRO";
    }
}