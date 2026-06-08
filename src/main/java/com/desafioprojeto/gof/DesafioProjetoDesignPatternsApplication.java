package com.desafioprojeto.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class DesafioProjetoDesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioProjetoDesignPatternsApplication.class, args);
	}

}
