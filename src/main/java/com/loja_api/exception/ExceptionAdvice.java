package com.loja_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public MensagemDTO handleRuntimeException(RuntimeException e) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setMensagem(e.getMessage());
        return mensagemDTO;
    }
    
}
