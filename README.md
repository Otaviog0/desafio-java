# Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias
SpringBoot
Java
Gradle(utilizado para build)

### Comando para rodar a aplicação
Variaveis de ambiente
spring.datasource.url= url do banco de dado/database
spring.datasource.username=usuario do banco de dados
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=informação de criação do hibernate create,update, drop-create

api.geolocation.key=key da api de geolocalização
{api.geolocation.url=http://www.mapquestapi.com/geocoding/v1/reverse

build
./gradlew bootRun --args='--api.geolocation.url=http://www.mapquestapi.com/geocoding/v1/reverse? --api.geolocation.key=suakey --spring.datasource.url=jdbc:mysql://localhost:3306/desafio --spring.datasource.username=root --spring.datasource.password=root --spring.jpa.hibernate.ddl-auto=update'

### Pendencias

Tratamento da exception para o codigo 01 -> Implementei a validação para o codigo 02 porem ficou pendente a do codigo 1

Adicionar query params para a url de consulta de geo localização -> a url esta com todos os parametro na mesma string é necessário quebrar ela em
queryparams para ficar mais usual no dia-a-dia

Reconfigurar o Dockerfile -> iniciei adicionando o dockerfile para usar o jetty porem ao rodar apresentou um erro e não deu tempo de ajustar, solução gerar um jar ao inves de um war

Deploy em produção -> atualmente não utilizei nenhum gratuito para subir a aplicação necessitava de um banco mysql






