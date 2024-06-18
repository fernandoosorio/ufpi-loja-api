package com.loja_api.model.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
}
