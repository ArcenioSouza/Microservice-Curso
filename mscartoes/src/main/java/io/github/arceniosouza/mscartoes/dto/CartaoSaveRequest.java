package io.github.arceniosouza.mscartoes.dto;

import io.github.arceniosouza.mscartoes.enums.BandeiraCartao;
import io.github.arceniosouza.mscartoes.model.Cartao;

import java.math.BigDecimal;

public record CartaoSaveRequest(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limite) {

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
