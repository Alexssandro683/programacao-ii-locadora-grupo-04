package model;
import java.util.ArrayList;
import java.util.List;

public class SistemaLocacao {
    private List<Locacao> locacoes = new ArrayList<>();


    //Buscar locação por ID
    public Locacao buscarLocacaoPorId(long id) {
        for (Locacao locacao : locacoes) {
            if (locacao.getId() == id) {
                return locacao;
            }
        }
        return null;
    }

    //Devolução do veículo
    public void devolverVeiculo(long id) {
        Locacao locacao = buscarLocacaoPorId(id);

        if (locacao == null) {
            throw new RegraNegocioException("Esta locação não foi encontrada.");
        }

        locacao.encerrar();
        locacao.getVeiculo().liberar();
    }

    //Listar todas as locações
    public List<Locacao> listarLocacoes() {
        return new ArrayList<>(locacoes);
    }

    //Listar as locações ativas
    public List<Locacao> listarLocacoesAtivas() {
        List<Locacao> ativas = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            if (locacao.isAtiva()) {
                ativas.add(locacao);
            }
        }
        return ativas;
    }

    //Listar as locações encerradas
    public List<Locacao> listarLocacoesEncerradas() {
        List<Locacao> encerradas = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            if (!locacao.isAtiva()) {
                encerradas.add(locacao);
            }
        }
        return encerradas;
    }
}
