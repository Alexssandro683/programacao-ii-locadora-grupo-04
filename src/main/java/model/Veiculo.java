
package model;

import java.util.Locale;

public abstract class Veiculo implements Locavel {

    private final String placa;
    private final String modelo;
    private final double valorDiaria;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, double valorDiaria) {

        if (placa == null || placa.isBlank()) {
            throw new RegraNegocioException("A placa é obrigatória.");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new RegraNegocioException("O modelo é obrigatório.");
        }

        if (!Double.isFinite(valorDiaria) || valorDiaria <= 0) {
            throw new RegraNegocioException("O valor da diária deve ser maior que zero.");
        }

        this.placa = placa.trim().toUpperCase(Locale.ROOT);
        this.modelo = modelo.trim();
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public abstract double calcularValorLocacao(int dias);
}
