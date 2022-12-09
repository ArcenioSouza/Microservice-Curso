package io.github.arceniosouza.msavaliadorcredito.service;

import feign.FeignException;
import io.github.arceniosouza.msavaliadorcredito.model.CartaoCliente;
import io.github.arceniosouza.msavaliadorcredito.model.DadosCliente;
import io.github.arceniosouza.msavaliadorcredito.model.SituacaoCliente;
import io.github.arceniosouza.msavaliadorcredito.model.exceptions.DadosClienteNotFoundException;
import io.github.arceniosouza.msavaliadorcredito.model.exceptions.ErroComunicacaoMicroservicesException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {
    private final ClienteServiceFeignClient clienteServiceFeignClient;
    private final CartoesServiceFeignClient cartoesServiceFeignClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
        //tratar erro de comunicação
        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = clienteServiceFeignClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> dadosCartoesResponse = cartoesServiceFeignClient.getCartoesByCpf(cpf);
            return SituacaoCliente
                    .builder()
                    .cliente(dadosClienteResponse.getBody())
                    .cartoes(dadosCartoesResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }
}
