package com.loja_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.loja_api.exception.DescontoForaIntervaloException;
import com.loja_api.exception.ProdutoNaoExisteException;
import com.loja_api.model.Produto;
import com.loja_api.model.dto.ProdutoDTO;
import com.loja_api.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoExisteException());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoExisteException());
        produtoRepository.delete(produto);
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoExisteException() );
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    //Este problema deve ser resolvido usando COPILOT
    public List<Produto> aplicarDescontoEmProdutos(ProdutoDTO produtoDTO) throws ProdutoNaoExisteException,DescontoForaIntervaloException {
        return null;
    }
}
