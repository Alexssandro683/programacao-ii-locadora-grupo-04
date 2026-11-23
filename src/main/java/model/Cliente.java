package model;

public class Cliente{
    private long id;
    private String nome;
    private String cpf;

    public Cliente (String nome, String cpf){
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        if (!cpfTemOnzeDigitos(cpfLimpo)){
            throw new IllegalArgumentException("CPF deve possuir 11 dígitos.");
        }
        this.nome = nome;
        this.cpf = cpfLimpo;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public long getId(){
        return id;
    }
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    public void setCpf(String novoCpf){
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
