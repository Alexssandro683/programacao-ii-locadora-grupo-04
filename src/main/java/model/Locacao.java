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
            throw new  RegraNegocioException("Ter cliente é obrigatório");
        }
        if (veiculo == null) {
            throw new  RegraNegocioException("Ter veículo é obrigatório");
        }

        if (diasContratados <= 0) {
            throw new RegraNegocioException("Quantidade de dias deve ser maior que zero.");
        }
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.diasContratados = diasContratados;
        this.valorTotal = veiculo.calcularValorLocacao(diasContratados);
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
    public void atribuirId(long novoId){
        if(novoId <=0){
            throw new RegraNegocioException("O ID da locação deve ser positivo.");
        }
        if(this.id !=0){
            throw new RegraNegocioException("O ID da locação já foi atribuido");
        }
        this.id = novoId;
    }
    public void encerrar(){
        if(!ativa){
            throw new RegraNegocioException("Esta locação já tá encerrada");
        }
        this.ativa = false;
    }
}
