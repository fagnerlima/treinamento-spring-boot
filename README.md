<h1>Desafio Klok Tech</h1>

<h2>Funcionalidades:</h2>

<ul>
    <li>Cadastrar, atualizar e cancelar venda(s)</li>
    <li>Listar venda(s)</li>
    <li>Gerar cobrança(s) das venda(s)</li>
    <li>Listar cobrança(s)</li>
    <li>Efetuar o pagamento da(s) cobrança(s)</li>
</ul> 

<h2>Tecnologias utilizadas:</h2>

<ul>
    <li>Java 11</li>
    <li>Maven</li>
    <li><strong>Spring Boot</strong></li>
    <li><strong>Spring Data</strong></li>
    <li><strong>Spring MVC</strong></li>
    <li>RabbitMQ</li>
    <li>Swagger</li>
    <li>TypeScript</li>
    <li><strong>Angular 14</strong></li>
    <li>Angular Material</li>
    <li>PostgreSQL</li>
    <li>Docker</li>
</ul>

<h2>Executando o projeto</h2>

<p>Seguir o passo a passo na ordem abaixo.</p>

<h3>- Executando o RabbitMQ</h3>

<p>Abra o terminal e execute o seguinte comando:</p>

> docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3.11-management

<h4>- Executando os bancos de dados</h4>

<p>Acesse o caminho Docker\db-vendas, dentro do repositório, no terminal, e execute o seguinte comando:</p>

> docker-compose up -d

<p>Em seguida acesse o caminho Docker\db-pagamentos, dentro do repositório, no terminal, e execute o mesmo comando:</p>

> docker-compose up -d

<h4>- Executando o back-end</h4>

<p>Acesse o caminho Backend/api-vendas, dentro do repositório, no terminal, e execute o comando:</p>

> mvn install

<p>Em seguida execute o comando abaixo e deixe o terminal aberto ou minimize:</p>

> java -jar api-vendas-0.0.1-SNAPSHOT.jar

<p>Acesse o caminho Backend/api-pagamentos, dentro do repositório, em um novo terminal, e execute o comando:</p>

> mvn install

<p>Em seguida execute o comando abaixo e deixe o terminal aberto ou minimize:</p>

> java -jar api-pagamentos-0.0.1-SNAPSHOT.jar

<p>Por último, acesse o caminho Frontend/app-vendas, dentro do repositório, em um novo terminal e execute o comando:</p>

> npm install

<p>Em seguida, execute o comando abaixo e deixe o terminal aberto ou minimize:</p>

> npm start

<p>Se tudo ocorrer bem, a aplicação estará disponivel nos seguintes caminhos (acesse pelo browser):</p>

<ul>
    <li>Front-End: http://localhost:4200</li>
    <li>API Vendas: http://localhost:8082/swagger-ui/</li>
    <li>API Pagamentos: http://localhost:8080/swagger-ui/</li>
    <li>RabbitMQ: http://localhost:15672 | usuário: guest - senha: guest</li>
</ul>