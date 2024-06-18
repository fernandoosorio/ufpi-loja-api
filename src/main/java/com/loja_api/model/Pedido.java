package com.loja_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
      name = "pedido_produto", 
      joinColumns = @JoinColumn(name = "pedido_id"), 
      inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    @Column
    private double valorTotal;

    @Column
    private String status;
}
