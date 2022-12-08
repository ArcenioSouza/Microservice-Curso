package io.github.arceniosouza.msclientes.dto;


import io.github.arceniosouza.msclientes.model.Cliente;

public record ClienteSaveRequest(String cpf, String nome, Integer idade) {

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}
