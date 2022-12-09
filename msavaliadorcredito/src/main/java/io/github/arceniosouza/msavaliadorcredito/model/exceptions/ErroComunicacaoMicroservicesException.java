package io.github.arceniosouza.msavaliadorcredito.model.exceptions;

import lombok.Getter;

public class ErroComunicacaoMicroservicesException extends Exception {
    @Getter
    private Integer status;

    public ErroComunicacaoMicroservicesException(String message, int status) {
        super(message);
        this.status = status;
    }
}
