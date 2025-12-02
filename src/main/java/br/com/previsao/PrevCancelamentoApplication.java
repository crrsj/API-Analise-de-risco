package br.com.previsao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Análise de risco",
				version = "1.0",
				description = "API para análise de de risco de cancelamentos",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class PrevCancelamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrevCancelamentoApplication.class, args);
	}

}
