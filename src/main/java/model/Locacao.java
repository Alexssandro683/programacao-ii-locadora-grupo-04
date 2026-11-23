package model;

public class Locacao {

    private long id;
    private Cliente cliente;
    private Veiculo veiculo;
    private  int diasContratados;
    private double valorTotal;
    private boolean ativa;

    public Locacao (Cliente cliente, Veiculo veiculo, int diasContratados) {

        if (cliente == null) {
            throw new IllegalArgumentException("Ter cliente é obrigatório");
        }
        if (veiculo == null) {
            throw new IllegalArgumentException("Ter veículo é obrigatório");
        }

        if (diasContratados <= 0) {
            throw new IllegalArgumentException("Quantidade de dias deve ser maior que zero.");
        }
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.diasContratados = diasContratados;
        this.ativa = true;
    }
    public long getId(){
        return id;
    }
    public int getDiasContratados(){
        return diasContratados;
    }
    public Cliente getCliente(){
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public double getValorTotal(){
        return valorTotal;
    }
    public boolean isAtiva(){
        return ativa;
    }
}
