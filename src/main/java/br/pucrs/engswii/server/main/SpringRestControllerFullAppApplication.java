package br.pucrs.engswii.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="br.pucrs.engswii")
@EntityScan(basePackages="br.pucrs.engswii")
@ComponentScan(basePackages="br.pucrs.engswii.controllers")
public class SpringRestControllerFullAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestControllerFullAppApplication.class, args);
	}
}