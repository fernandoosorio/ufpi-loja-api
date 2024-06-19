package com.loja_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
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
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "ProdutoInexistente", null, 100.0, null, 50.0);
        when(produtoRepository.findByNomeContaining("ProdutoInexistente")).thenReturn(Collections.emptyList());

        assertThrows(ProdutoNaoExisteException.class, () -> {
            produtoService.aplicarDescontoEmProdutos(produtoDTO);
        });
    }

    @Test
    public void testAplicarDescontoEmTodosProdutos() {
        ProdutoDTO produtoDTO =  new ProdutoDTO(1L, null, null, null, null, Double.valueOf(50));
        doReturn(Arrays.asList(
            new Produto(1L, "Produto1", null, 100.0, null), 
            new Produto(2L, "Produto2", null, 200.0, null)
        )).when(produtoRepository).findAll();

        List<Produto> produtos = produtoService.aplicarDescontoEmProdutos(produtoDTO);

        assertEquals(Double.valueOf(50), produtos.get(0).getPreco());
        assertEquals(Double.valueOf(100), produtos.get(1).getPreco());
    }

    @Test
    public void testAplicarDescontoForaIntervalo() {

        doReturn(Arrays.asList(
            new Produto(1L, "Produto1", null, 100.0, null), 
            new Produto(2L, "Produto2", null, 200.0, null)
        )).when(produtoRepository).findAll();

       
        assertThrows(DescontoForaIntervaloException.class, () -> {
            ProdutoDTO produtoDTO = new ProdutoDTO(1L, null, null, null, null, Double.valueOf(110));
            produtoService.aplicarDescontoEmProdutos(produtoDTO);
        });

        assertThrows(DescontoForaIntervaloException.class, () -> {
            ProdutoDTO produtoDTO = new ProdutoDTO(1L, null, null, null, null, Double.valueOf(0));
            produtoService.aplicarDescontoEmProdutos(produtoDTO);
        });

    }


    /*
     * @Testes para verificar disponibilidade
     */

    @Test
    public void testVerificarDisponibilidadeProdutoExistenteTrue() {
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Produto1", null, null, null, null);
        when(produtoRepository.findByNomeContaining("Produto1")).thenReturn(Arrays.asList(new Produto(1L, "Produto1", null, 100.0, 10)));

        boolean disponibilidade = produtoService.verificarDisponibilidade(produtoDTO);

        assertTrue(disponibilidade);
    }

    @Test
    public void testVerificarDisponibilidadeProdutoExistenteFalse() {
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Produto1", null, null, null, null);
        when(produtoRepository.findByNomeContaining("Produto1")).thenReturn(Arrays.asList(new Produto(1L, "Produto1", null, 100.0, 0)));

        boolean disponibilidade = produtoService.verificarDisponibilidade(produtoDTO);

        assertFalse(disponibilidade);
    }

    
    


    @Test
    public void testVerificarDisponibilidadeProdutoInexistente() {
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "ProdutoInexistente", null, null, null, null);
        when(produtoRepository.findByNomeContaining("ProdutoInexistente")).thenReturn(Collections.emptyList());

        assertThrows(ProdutoNaoExisteException.class, () -> {
            produtoService.verificarDisponibilidade(produtoDTO);
        });
    }
}