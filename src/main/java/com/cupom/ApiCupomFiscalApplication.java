package com.cupom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.cupom.infrastructure.adapters.elastic")
@EnableJpaRepositories(basePackages = "com.cupom.infrastructure.adapters.repository")
public class ApiCupomFiscalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCupomFiscalApplication.class, args);
	}

}
