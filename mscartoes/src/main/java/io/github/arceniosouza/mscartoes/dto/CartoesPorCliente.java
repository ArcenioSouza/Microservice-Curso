package io.github.arceniosouza.mscartoes.dto;

import io.github.arceniosouza.mscartoes.model.ClienteCartao;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
public record CartoesPorCliente(String nome, String bandeira, BigDecimal limiteLiberado) {

    public static CartoesPorCliente fromModel(ClienteCartao clienteCartao){
        return new CartoesPorCliente(
                clienteCartao.getCartao().getNome(),
                clienteCartao.getCartao().getBandeira().toString(),
                clienteCartao.getLimite()
                );
    }
}
