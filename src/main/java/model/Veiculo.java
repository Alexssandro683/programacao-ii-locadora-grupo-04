
package model;

import java.util.Locale;

public abstract class Veiculo implements Locavel {

    private final String placa;
    private final String modelo;
    private final double valorDiaria;
    private boolean disponivel;
    private long id;
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

    public long getId(){
        return id;
    }
    public void definirId(long id) {
        this.id = id;
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

    public void ocupar() {
        if (!disponivel) {
            throw new RegraNegocioException("O veículo já está ocupado.");
        }

        disponivel = false;
    }

    public void liberar() {
        if (disponivel) {
            throw new RegraNegocioException("O veículo já está disponível.");
        }

        disponivel = true;
    }

    @Override
    public abstract double calcularValorLocacao(int dias);

    public abstract String getTipo();
}
