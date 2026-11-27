package model;
import java.util.ArrayList;
import java.util.List;

public class SistemaLocacao {
    private List<Locacao> locacoes = new ArrayList<>();
    private long proximoIdLocacao = 1;

    //======================= INTEGRAÇÃO DE LOCAÇÃO ==============================
    public Locacao registrarLocacao(long idCliente, String placa, int diasContratados) {
        Cliente cliente = buscarPorId(idCliente);
        if (cliente == null) {
            throw new RegraNegocioException("cliente não foi encontrado.");

        }
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo == null) {
            throw new RegraNegocioException("o veículo não foi encontrado.");
        }
        if (!veiculo.isDisponivel()) {
            throw new RegraNegocioException("o veiculo não está disponível");
        }
        Locacao novaLocacao = new Locacao(cliente, veiculo, diasContratados);
        novaLocacao.atribuirId(proximoIdLocacao);
        veiculo.ocupar();
        locacoes.add(novaLocacao);
        proximoIdLocacao++;

        return novaLocacao;

    }
}