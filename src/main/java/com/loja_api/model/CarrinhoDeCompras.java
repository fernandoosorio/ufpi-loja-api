package com.loja_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class CarrinhoDeCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "carrinho_itens", joinColumns = @JoinColumn(name = "carrinho_id"))
    @MapKeyJoinColumn(name = "produto_id")
    @Column(name = "quantidade")
    private Map<Produto, Integer> itens = new HashMap<>();

    public void adicionarItem(Produto produto, int quantidade) {
        itens.put(produto, itens.getOrDefault(produto, 0) + quantidade);
    }

    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    public void atualizarQuantidadeItem(Produto produto, int quantidade) {
        if (itens.containsKey(produto)) {
            itens.put(produto, quantidade);
        }
    }

    public void limparCarrinho() {
        itens.clear();
    }
}
