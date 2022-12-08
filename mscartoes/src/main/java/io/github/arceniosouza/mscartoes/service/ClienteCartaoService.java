package io.github.arceniosouza.mscartoes.service;

import io.github.arceniosouza.mscartoes.model.ClienteCartao;
import io.github.arceniosouza.mscartoes.repositoy.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listaCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
