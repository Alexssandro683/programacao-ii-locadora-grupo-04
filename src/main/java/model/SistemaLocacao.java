package model;

import java.util.ArrayList;
import java.util.List;

public class SistemaLocacao {
    private List<Cliente> clientes = new ArrayList<>();
    private long proximoId = 1;

    public void cadastrarCliente(String nome, String cpf){
        if (cpf == null){
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpfLimpo)){
                throw new IllegalArgumentException("Já existe um cliente cadastrado com esse CPF.");
            }
        }
        Cliente novoCliente = new Cliente(nome, cpf);

        novoCliente.atribuirId(proximoId);

        clientes.add(novoCliente);

        proximoId++;
    }
    public Cliente buscarPorId(long id){
        for (Cliente cliente : clientes){
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
    public Cliente buscarPorCpf(String cpf){
        if (cpf == null){
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpfLimpo)){
                return cliente;
            }
        }
        return null;
    }
    public void atualizarCliente(long id, String novoNome, String novoCpf){
        Cliente cliente = buscarPorId(id);

        if (cliente == null){
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        if (novoNome == null || novoNome.isBlank()){
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (novoCpf == null){
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        String cpfLimpo = novoCpf.replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11){
            throw new IllegalArgumentException("CPF deve possuir 11 dígitos.");
        }
        for (Cliente outroCliente : clientes){
            if (outroCliente.getCpf().equals(cpfLimpo) && outroCliente.getId() != id){
                throw new IllegalArgumentException("Já existe outro cliente cadastrado com esse CPF.");
            }
        }
        cliente.setNome(novoNome);
        cliente.setCpf(cpfLimpo);
    }
    public void removerCliente(long id) {
        Cliente cliente = buscarPorId(id);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        clientes.remove(cliente);
    }
}
