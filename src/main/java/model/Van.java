package model;

public abstract class Van extends Veiculo {

    public Van(String placa, String modelo, double valorDiaria) {
        super(placa, modelo, valorDiaria);
    }

    @Override
    public String getTipo() {
        return "VAN";
    }
}