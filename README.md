# treinamento spring boot

## REQUISITOS:
- Implementar uma api capaz de gerenciar adesões (cadastrar; atualizar; e cancelar;) e agendar cobranças;
- Implementar uma api que recebe cobranças do serviço acima, via fila (RabbitMQ) e que recebe pagamentos das cobranças via HTTP/REST.
- Os serviços e bancos deverão subir através de containers Docker;
- Ambas apis deverão ser privadas, sendo necessário informar um token JWT para acessá-las;
- Testes unitários;


## TECNOLOGIAS:
- Java 8+
- Spring Boot
- Spring Security
- Spring Data
- Spring MVC
- JWT
- RabbitMQ
- SQL Migration com Flyway
- ApiDoc com Swagger
- Postgres


## CRITÉRIOS AVALIADOS:
- Funcionamento;
- Consistência do modelo / aderência ao mundo real;
- Qualidade do código;
- Inovação;
- Testes;
