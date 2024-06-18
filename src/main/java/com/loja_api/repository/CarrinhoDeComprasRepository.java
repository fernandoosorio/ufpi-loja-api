package com.loja_api.repository;

import com.loja_api.model.CarrinhoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompras, Long> {
}
