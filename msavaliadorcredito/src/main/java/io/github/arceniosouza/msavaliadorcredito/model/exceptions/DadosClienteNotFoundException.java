package io.github.arceniosouza.msavaliadorcredito.model.exceptions;

public class DadosClienteNotFoundException extends Exception {
    public DadosClienteNotFoundException() {
        super("Dados do cliente referente a esse CPF não foi encontrado");
    }
}
