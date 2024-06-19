# Problemas

**Observação:** apenas a classe `ProdutoService` deve ser alterada, as classes controller e repository já possuem os métodos suficientes para executar o código sem erros.

## Responder usando COPILOT
 1. Implementar o método `ProdutoService.aplicarDescontoEmProdutos(ProdutoDTO produtoDTO)` chamado pelo controller `ProdutoController`.
 ```java
public List<Produto> aplicarDescontoEmProdutos(ProdutoDTO produtoDTO) throws ProdutoNaoExisteException, DescontoForaIntervaloException;
```
- Esse método aplicar um percentual de desconto a um produto ou a todos.
- O método recebe como parâmetro `produtoDTO`.
  - Se estiver preenchido o campo `produtoDTO.getNome()` o desconto deve ser aplicado apenas aos produtos que possuem esse nome (caso não exista produtos com o nome enviado disparar `ProdutoNaoExisteException`); 
  - No caso desse campo `produtoDTO.getNome()` estar null/vazio deve ser aplicado a TODOS os produtos.
  - O valor do desconto é enviado no campo `produtoDTO.getDesconto()`. Desconto deve ser valor maior que 0 e menor que 100%, senão deve disparar `DescontoForaIntervaloException`.


**Lembre-se de exportar o chat `Ctrl+Shift+P | Chat: Export Session/Exportar Chat`**

## Responder sem ferramentas de apoio à geração de código

2. Implementar o método `ProdutoService.verificarDisponibilidade(ProdutoDTO produtoDTO)` chamado pelo controller `ProdutoController`.

```java

 public boolean verificarDisponibilidade(ProdutoDTO produtoDTO) throws ProdutoNaoExisteException;
```

- Esse método verifica se um determinado produto possui estoque.
- Se o produto não existir ( `produtoDTO.getNome()` ) disparar a exceção `ProdutoNaoExisteException`.
- Se o produto existir e o estoque for maior que zero returnar true, senão false.



