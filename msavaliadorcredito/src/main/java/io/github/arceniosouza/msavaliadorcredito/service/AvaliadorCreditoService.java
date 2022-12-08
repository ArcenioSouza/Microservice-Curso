package io.github.arceniosouza.msavaliadorcredito.service;

import io.github.arceniosouza.msavaliadorcredito.model.CartaoCliente;
import io.github.arceniosouza.msavaliadorcredito.model.DadosCliente;
import io.github.arceniosouza.msavaliadorcredito.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {
    private final ClienteServiceFeignClient clienteServiceFeignClient;
    private final CartoesServiceFeignClient cartoesServiceFeignClient;

    public SituacaoCliente obterSituacaoCliente(String cpf){
        ResponseEntity<DadosCliente> dadosClienteResponse = clienteServiceFeignClient.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> dadosCartoesResponse = cartoesServiceFeignClient.getCartoesByCpf(cpf);
        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(dadosCartoesResponse.getBody())
                .build();
    }
}
