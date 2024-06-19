package com.loja_api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_api.model.Produto;
import com.loja_api.model.dto.ProdutoDTO;
import com.loja_api.service.ProdutoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.criarProduto(produtoDTO);
        return ResponseEntity.ok(toDto(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.atualizarProduto(id, produtoDTO);
        return ResponseEntity.ok(toDto(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(toDto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        List<ProdutoDTO> produtoDTOs = produtos.stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(produtoDTOs);
    }

    @PostMapping("/desconto")
    public ResponseEntity<List<ProdutoDTO>> aplicarDescontoEmProdutos(@RequestBody ProdutoDTO produtoDTO)  throws Exception{
        List<Produto> produtos = produtoService.aplicarDescontoEmProdutos(produtoDTO);
        List<ProdutoDTO> produtoDTOs = produtos.stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(produtoDTOs);
    }

    @GetMapping("/verificarDisponibilidade")
    public ResponseEntity<Boolean> verificarDisponibilidade(@RequestBody ProdutoDTO produtoDTO) throws Exception {
        
        boolean disponibilidade = produtoService.verificarDisponibilidade(produtoDTO);
        return ResponseEntity.ok(disponibilidade);
       
    }


    private ProdutoDTO toDto(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setPreco(produto.getPreco());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return dto;
    }
}

