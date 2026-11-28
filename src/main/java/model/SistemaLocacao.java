package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SistemaLocacao {

    private final List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) {

        if (veiculo == null) {
            throw new RegraNegocioException("Veículo inválido.");
        }

        if (buscarVeiculoPorPlaca(veiculo.getPlaca()) != null) {
            throw new RegraNegocioException(
                    "Já existe um veículo cadastrado com essa placa."
            );
        }

        veiculos.add(veiculo);
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {

        if (placa == null || placa.isBlank()) {
            throw new RegraNegocioException("A placa é obrigatória.");
        }

        String placaNormalizada = placa.trim().toUpperCase(Locale.ROOT);

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placaNormalizada)) {
                return veiculo;
            }
        }

        return null;
    }
}