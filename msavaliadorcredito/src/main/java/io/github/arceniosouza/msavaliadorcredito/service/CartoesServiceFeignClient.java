package io.github.arceniosouza.msavaliadorcredito.service;

import io.github.arceniosouza.msavaliadorcredito.model.CartaoCliente;
import io.github.arceniosouza.msavaliadorcredito.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesServiceFeignClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<CartaoCliente>> getCartoesByCpf(@RequestParam("cpf") String cpf);
}
