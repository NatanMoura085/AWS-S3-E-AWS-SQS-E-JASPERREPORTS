# Spring Boot API - Geração de Cupom Fiscal com JasperReports e AWS S3,AWS SQS

Este projeto é uma API REST desenvolvida em **Spring Boot** para gerar cupons fiscais em **PDF** utilizando **JasperReports** e armazená-los no **AWS S3** e enviar mensagens para uma **fila AWS SQS** para processamento assíncrono.

## 🚀 Funcionalidades

- **Geração de PDF**: Cria cupons fiscais em formato PDF a partir dos dados enviados via API.
- **Armazenamento no AWS S3**: O PDF gerado é salvo automaticamente em um bucket do **AWS S3**.
- **Retorno da URL**: A API retorna a URL do arquivo armazenado para download.
- **Fila AWS SQS**: Uma mensagem contendo a chave do PDF gerado é enviada para uma fila **AWS SQS** para processamento assíncrono e rastreamento.
- **Persistência com JPA**: Dados do cupom fiscal são persistidos no banco de dados utilizando **JPA** (Java Persistence API) e **Spring Data JPA**.
- **Arquitetura Hexagonal**: A aplicação segue a **Arquitetura Hexagonal**, onde a lógica de negócio é separada da infraestrutura (como banco de dados, S3, SQS, etc.), tornando o sistema mais modular, testável e fácil de manter.
## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3**
- **JasperReports** (para gerar PDFs)
- **AWS SDK (S3)** (para armazenar os arquivos gerados)
- **AWS CLOUD (SQS)** (para enviar mensagens para a fila SQS)
- **Lombok** (para redução de boilerplate)
- **Spring Data JPA** (para persistência de dados no banco)
- **Arquitetura Hexagonal** (Clean Architecture)

## 📦 Dependências (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>

    <!-- JasperReports -->
    <dependency>
        <groupId>net.sf.jasperreports</groupId>
        <artifactId>jasperreports</artifactId>
        <version>6.20.0</version>
    </dependency>

    <!-- AWS SDK para S3 -->
    <dependency>
        <groupId>software.amazon.awssdk</groupId>
        <artifactId>s3</artifactId>
        <version>2.20.66</version>
    </dependency>
   <!-- AWS CLOUD para SQS -->
   <dependency>
      <groupId>io.awspring.cloud</groupId>
      <artifactId>spring-cloud-aws-sqs</artifactId>
      <version>3.3.0</version>
   </dependency>
   <!-- SPRING JPA para Persistência de dados no banco -->
   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
</dependencies>
```

## 🔧 Configuração do AWS S3
Antes de iniciar o projeto, configure o **AWS S3** no `application.properties`:

```properties
aws.s3.bucket-name=bucket-cupons
aws.s3.region=us-east-1
aws.access-key=SEU_ACCESS_KEY
aws.secret-key=SEU_SECRET_KEY
```

## 🎯 Como Rodar o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/NatanMoura085/AWS-S3-E-AWS-SQS-E-JASPERREPORTS.git
   ```

2. Acesse o diretório do projeto:
   ```sh
   cd api-cupom-fiscal
   ```

3. Configure as credenciais da AWS no `application.properties`.

4. Compile e rode a aplicação:
   ```sh
   mvn spring-boot:run
   ```

5. A API estará disponível em:  
   📍 **http://localhost:8081/v1/api/cupons**

## 📡 Endpoints da API

### 🔹 **Gerar Cupom Fiscal**

- **URL:** `POST /cupons`
- **Request Body:**

```json
{
  "numeroCupom": "123456",
  "cnpj": "12.345.678/0001-99",
  "valor": "99.90",
  "dataEmissao": "2024-02-23"
}
```

- **Resposta:**

```json
"https://bucket-cupons.s3.amazonaws.com/cupons/123456.pdf"
```

Agora é só acessar a URL e baixar o cupom! 🚀

