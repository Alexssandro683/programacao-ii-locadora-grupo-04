package model;

public abstract class Moto extends Veiculo {

    public Moto(String placa, String modelo, double valorDiaria) {
        super(placa, modelo, valorDiaria);
    }

    @Override
    public String getTipo() {
        return "MOTO";
    }
}