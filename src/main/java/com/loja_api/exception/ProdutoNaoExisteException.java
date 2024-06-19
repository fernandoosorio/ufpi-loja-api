package com.loja_api.exception;

public class ProdutoNaoExisteException extends RuntimeException{
    public ProdutoNaoExisteException() {
        super("Produto não encontrado");
    }
    
}
