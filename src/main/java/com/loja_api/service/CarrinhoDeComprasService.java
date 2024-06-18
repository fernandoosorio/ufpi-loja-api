package com.loja_api.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.loja_api.model.CarrinhoDeCompras;
import com.loja_api.model.Produto;
import com.loja_api.model.dto.CarrinhoDeComprasDTO;
import com.loja_api.repository.CarrinhoDeComprasRepository;
import com.loja_api.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarrinhoDeComprasService {

    private final CarrinhoDeComprasRepository carrinhoDeComprasRepository;
    private final ProdutoRepository produtoRepository;

    public CarrinhoDeComprasDTO adicionarItem(CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(); // Cria um novo carrinho para cada requisição
        Produto produto = produtoRepository.findById(carrinhoDeComprasDTO.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        carrinho.adicionarItem(produto, carrinhoDeComprasDTO.getQuantidade());
        carrinhoDeComprasRepository.save(carrinho);
        return toDto(carrinho);
    }

    public CarrinhoDeComprasDTO removerItem(CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(); // Cria um novo carrinho para cada requisição
        Produto produto = produtoRepository.findById(carrinhoDeComprasDTO.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        carrinho.removerItem(produto);
        carrinhoDeComprasRepository.save(carrinho);
        return toDto(carrinho);
    }

    public CarrinhoDeComprasDTO atualizarQuantidadeItem(CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(); // Cria um novo carrinho para cada requisição
        Produto produto = produtoRepository.findById(carrinhoDeComprasDTO.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        carrinho.atualizarQuantidadeItem(produto, carrinhoDeComprasDTO.getQuantidade());
        carrinhoDeComprasRepository.save(carrinho);
        return toDto(carrinho);
    }

    public CarrinhoDeComprasDTO getCarrinho() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(); // Cria um novo carrinho para cada requisição
        return toDto(carrinho);
    }

    public void limparCarrinho() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(); // Cria um novo carrinho para cada requisição
        carrinho.limparCarrinho();
        carrinhoDeComprasRepository.save(carrinho);
    }

    private CarrinhoDeComprasDTO toDto(CarrinhoDeCompras carrinho) {
        CarrinhoDeComprasDTO dto = new CarrinhoDeComprasDTO();
        dto.setItens(carrinho.getItens().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getId(),
                        Map.Entry::getValue
                )));
        return dto;
    }
}
