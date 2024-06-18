
# Sistema de Loja Online

### Para executar este projeto
- baixe ou clone o projeto `git clone https://github.com/fernandoosorio/ufpi-loja-api`

- Acesse o diretório  `cd ufpi-loja-api`

- Verificar versão do java ( `java --version`) deve estar na versão 17

- No linux para escolher diferentes versões do java é preciso fazer `sudo update-alternatives --config java`

- Execute `mvn dependency:resolve`  (precisa estar na vesão 17 do Java)  
    - Para instalar mvn no [windows](https://dicasdeprogramacao.com.br/como-instalar-o-maven-no-windows/)  ou [linux](https://dicasdeprogramacao.com.br/como-instalar-o-maven-no-windows/)

- Se tudo ocorreu como esperado: no console deve aparecer `[INFO] BUILD SUCCESS`


- Abrir o projeto na sua IDE de preferência.

- Executar o projeto ( executar/debugar o arquivo `LojaApiApplication.java`)

- Para visualizar o banco de dados:
    -   Acessar  http://localhost:8080/h2-console
        - Preencher os campos:
            - JDBC URL: `jdbc:h2:mem:loja`
            - User Name: `sa`
            - Password: `123`
            - Click em `Connect`

- Para visualizar os endereços da API:
    -   Acessar  http://localhost:8080/swagger-ui/index.html
