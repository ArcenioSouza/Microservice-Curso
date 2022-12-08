package io.github.arceniosouza.msavaliadorcredito.service;

import io.github.arceniosouza.msavaliadorcredito.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Service
@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteServiceFeignClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> dadosCliente(@RequestParam("cpf") String cpf);
}
