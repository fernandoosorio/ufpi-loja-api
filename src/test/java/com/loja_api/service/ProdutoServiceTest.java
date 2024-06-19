package com.loja_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.loja_api.exception.DescontoForaIntervaloException;
import com.loja_api.exception.ProdutoNaoExisteException;
import com.loja_api.model.Produto;
import com.loja_api.model.dto.ProdutoDTO;
import com.loja_api.repository.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    public void testAplicarDescontoEmProdutosComNomeExistente() {
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Produto1", null, null, null, 50.0);
        Produto produto = new Produto(1L, "Produto1", null, 100.0, null);
        when(produtoRepository.findByNomeContaining("Produto1")).thenReturn(Arrays.asList(produto));

        List<Produto> produtos = produtoService.aplicarDescontoEmProdutos(produtoDTO);

        assertEquals(Double.valueOf(50), produtos.get(0).getPreco());
       

    }

    @Test
    public void testAplicarDescontoEmProdutosComNomeInexistente() {
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "ProdutoInexistente", null, null, null, null);
        when(produtoRepository.findByNomeContaining("ProdutoInexistente")).thenReturn(Collections.emptyList());

        assertThrows(ProdutoNaoExisteException.class, () -> {
            produtoService.aplicarDescontoEmProdutos(produtoDTO);
        });
    }

    @Test
    public void testAplicarDescontoEmTodosProdutos() {
        ProdutoDTO produtoDTO =  new ProdutoDTO(1L, null, null, null, null, Double.valueOf(50));
        when(produtoRepository.findAll()).thenReturn(Arrays.asList(new Produto(1L, "Produto1", null, 100.0, null), 
        new Produto(2L, "Produto2", null, 200.0, null)));

        List<Produto> produtos = produtoService.aplicarDescontoEmProdutos(produtoDTO);

        assertEquals(Double.valueOf(50), produtos.get(0).getPreco());
        assertEquals(Double.valueOf(100), produtos.get(1).getPreco());
    }

    @Test
    public void testAplicarDescontoForaIntervalo() {
        assertThrows(DescontoForaIntervaloException.class, () -> {
            ProdutoDTO produtoDTO = new ProdutoDTO(1L, null, null, null, null, Double.valueOf(110));
            produtoService.aplicarDescontoEmProdutos(produtoDTO);
        });

        assertThrows(DescontoForaIntervaloException.class, () -> {
            ProdutoDTO produtoDTO = new ProdutoDTO(Long.valueOf(1), "Produto1", null, null, null, Double.valueOf(0));
            produtoService.aplicarDescontoEmProdutos(produtoDTO);
        });
    }
}