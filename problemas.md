# Problemas
## Responder usando COPILOT
 1. Implementar o método `ProdutoService.aplicarDescontoEmProdutos(ProdutoDTO produtoDTO)` pelo controller `ProdutoController`.
 ```java
public List<Produto> aplicarDescontoEmProdutos(ProdutoDTO produtoDTO) throws ProdutoNaoExisteException, DescontoForaIntervaloException;
```

- Esse método deve disparar as exceções ProdutoNaoExisteException, DescontoForaIntervaloException  conforme assinatura do método. 

- O método recebe como parâmetro `produtoDTO`.
  - Se estiver preenchido o campo `produtoDTO.getNome()` o desconto deve ser aplicado apenas ao produtos que possuem esse nome (caso não existe produtos com o nome enviado disparar ProdutoNaoExisteException); 
  - No caso desse campo `produtoDTO.getNome()` estar null/vazio deve ser aplicado a todos os produtos.
  - O valor do desconto é enviado no campo `produtoDTO.getDesconto()`. Desconto deve ser valor maior que 0 e menor que 100%. 


**Lembre-se de exportar o chat `Ctrl+Shift+P | Chat: Export Session/Exportar Chat`**

### Próximo

2. Implementar o método `VeiculoService.aumentarDiaria(int tipo, double taxaAumento)` que registra o aumento das diárias dos veículos, usando os códigos para o tipo (parâmetro do método):  
- 0 (todos os veículos), 
- 1 (moto), 2 (carro), 
- 3 (caminhão) ou
- 4 (ônibus) 
- Senão lancar exceção `TipoVeiculoDesconhecido`

A taxaAumento é um valor entre 0 e 100, que representa a porcentagem de aumento da diária, senão lançar a exceção `TaxaAumentoForaIntervalo`.

```java
 @Override
public void aumentarDiaria(int tipo, double taxaAumento);
```

**Lembre-se de exportar o chat `Ctrl+Shift+P | Chat: Export Session...`**

### Próximo

3. Implementar o método `editar` no controller `LocadoraImplController` que possui a seguinte assinatura:

```java
@PutMapping("/edit/cliente/{id}") 
    public ResponseEntity<ClienteDto> editar(@RequestBody  ClienteDto c, @PathVariable Integer id) throws ClienteNaoCadastrado, SQLException;
```

Esse método será responsável por editar um cliente caso ele exista ou disparar uma exceção `ClienteNaoCadastrado` quando o cliente não existir.

Neste problema será necessário, ainda o método `editar` em `ClienteService.java` para realizar as validações e persistir a entidade.

**Lembre-se de exportar o chat `Ctrl+Shift+P | Chat: Export Session...`**