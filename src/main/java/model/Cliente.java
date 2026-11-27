package model;

public class Cliente {
    private long id;
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        if (nome == null || nome.isBlank()){
            throw new RegraNegocioException("Nome não pode ser vazio.");
        }
        if (cpf == null){
            throw new RegraNegocioException("CPF não pode ser nulo.");
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        if (!cpfTemOnzeDigitos(cpfLimpo)){
            throw new RegraNegocioException("CPF deve possuir 11 dígitos.");
        }
        this.nome = nome;
        this.cpf = cpfLimpo;
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public long getId() {
        return id;
    }
    public void atribuirId(long novoId){
        if (novoId <= 0){
            throw new RegraNegocioException("ID deve ser positivo.");
        }
        if (this.id != 0){
            throw new RegraNegocioException("ID já foi atribuído.");
        }
        this.id = novoId;
    }
    public void setNome(String novoNome){
        if (novoNome == null || novoNome.isBlank()){
            throw new RegraNegocioException("Nome não pode ser vazio.");
        }
        this.nome = novoNome;
    }
    public void setCpf(String novoCpf){
        if (novoCpf == null){
            throw new RegraNegocioException("CPF não pode ser nulo.");
        }
        String cpfLimpo = novoCpf.replaceAll("[^0-9]", "");

        if (!cpfTemOnzeDigitos(cpfLimpo)){
            throw new RegraNegocioException("CPF deve possuir 11 dígitos.");
        }
        this.cpf = cpfLimpo;
    }
    private boolean cpfTemOnzeDigitos(String cpf){
        return cpf.length() == 11;
    }
}
