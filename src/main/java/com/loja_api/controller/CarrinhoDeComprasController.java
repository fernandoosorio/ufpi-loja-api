package com.loja_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_api.model.dto.CarrinhoDeComprasDTO;
import com.loja_api.service.CarrinhoDeComprasService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/carrinho")
@AllArgsConstructor
public class CarrinhoDeComprasController {

    private CarrinhoDeComprasService carrinhoDeComprasService;

    @PostMapping("/adicionar")
    public ResponseEntity<CarrinhoDeComprasDTO> adicionarItem(@RequestBody CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeComprasDTO carrinhoDTO = carrinhoDeComprasService.adicionarItem(carrinhoDeComprasDTO);
        return ResponseEntity.ok(carrinhoDTO);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<CarrinhoDeComprasDTO> removerItem(@RequestBody CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeComprasDTO carrinhoDTO = carrinhoDeComprasService.removerItem(carrinhoDeComprasDTO);
        return ResponseEntity.ok(carrinhoDTO);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<CarrinhoDeComprasDTO> atualizarQuantidade(@RequestBody CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeComprasDTO carrinhoDTO = carrinhoDeComprasService.atualizarQuantidadeItem(carrinhoDeComprasDTO);
        return ResponseEntity.ok(carrinhoDTO);
    }

    @GetMapping
    public ResponseEntity<CarrinhoDeComprasDTO> getCarrinho() {
        CarrinhoDeComprasDTO carrinhoDTO = carrinhoDeComprasService.getCarrinho();
        return ResponseEntity.ok(carrinhoDTO);
    }

    @DeleteMapping("/limpar")
    public ResponseEntity<Void> limparCarrinho() {
        carrinhoDeComprasService.limparCarrinho();
        return ResponseEntity.noContent().build();
    }
}
