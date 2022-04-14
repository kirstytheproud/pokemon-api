package com.example.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin
@RestController
public class PokemonApplication {

	public static void main(String[] args) {

		SpringApplication.run(PokemonApplication.class, args);
	}

}
