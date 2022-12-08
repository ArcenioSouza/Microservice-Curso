package io.github.arceniosouza.mscartoes.controller;

import io.github.arceniosouza.mscartoes.dto.CartaoSaveRequest;
import io.github.arceniosouza.mscartoes.dto.CartoesPorCliente;
import io.github.arceniosouza.mscartoes.model.Cartao;
import io.github.arceniosouza.mscartoes.model.ClienteCartao;
import io.github.arceniosouza.mscartoes.service.CartaoService;
import io.github.arceniosouza.mscartoes.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRenda(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorCliente>> getCartoesByCpf(@RequestParam("cpf") String cpf){
        List<ClienteCartao> list = clienteCartaoService.listaCartoesByCpf(cpf);
        List<CartoesPorCliente> resultList = list.stream()
                .map(CartoesPorCliente::fromModel).toList();
        return ResponseEntity.ok(resultList);
    }
}
