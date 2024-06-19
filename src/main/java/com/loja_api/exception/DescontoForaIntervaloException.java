package com.loja_api.exception;

public class DescontoForaIntervaloException extends RuntimeException{
    public DescontoForaIntervaloException() {
        super("Desconto deve ser maior que 0 e menor que 100%");
    }
    
}
