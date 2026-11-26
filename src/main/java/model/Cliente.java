package model;

public class Cliente {
    private long id;
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (cpf == null){
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        if (!cpfTemOnzeDigitos(cpfLimpo)){
            throw new IllegalArgumentException("CPF deve possuir 11 dígitos.");
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
    void atribuirId(long novoId){
        if (novoId <= 0){
            throw new IllegalArgumentException("ID deve ser positivo.");
        }
        if (this.id != 0){
            throw new IllegalArgumentException("ID já foi atribuido.");
        }
        this.id = novoId;
    }
    public void setNome(String novoNome){
        if (novoNome == null || novoNome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = novoNome;
    }
    public void setCpf(String novoCpf){
        if (novoCpf == null){
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        String cpfLimpo = novoCpf.replaceAll("[^0-9]", "");

        if (!cpfTemOnzeDigitos(cpfLimpo)){
            throw new IllegalArgumentException("CPF deve possuir 11 dígitos.");
        }
        this.cpf = cpfLimpo;
    }
    private boolean cpfTemOnzeDigitos(String cpf){
        return cpf.length() == 11;
    }
}
