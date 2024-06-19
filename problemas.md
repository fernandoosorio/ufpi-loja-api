# Problemas
## Responder usando COPILOT
 1. Implementar o método `VeiculoService.registrarAluguel(placa, data, dias, cpf)` chamado dentro do método  `registrarAluguel` do controller `LocadadoraImplController.java`.
Esse método deve disparar as exceções VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado  conforme assinatura do método. O método recebe os parâmetros placa, dataInicio do aluguel, o número de dias e o CPF do cliente que está realizando o aluguel. 
Abaixo o trecho de código que chama esse método:

```java
public void registrarAluguel(String placa, Date data, int dias, Long cpf) throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado;
```
Observações: 
  - A classe `Aluguel` precisar ter preenchidos os atributos: `cliente`, `veiculo`,`dataInicio`, `dataFim` e `totalAluguel(valor total devido pelo aluguel)` preenchidos, inclusive essa classe possui um construtor com esses campos nessa ordem.

**Lembre-se de exportar o chat `Ctrl+Shift+P | Chat: Export Session...`**

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