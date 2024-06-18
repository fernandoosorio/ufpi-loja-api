package com.loja_api.model.dto;

import java.util.Map;

import lombok.Data;

@Data
public class CarrinhoDeComprasDTO {
    private Long produtoId;
    private int quantidade;
    private Map<Long, Integer> itens; 
}