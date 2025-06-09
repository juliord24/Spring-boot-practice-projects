package com.juliord24.springDataJPACourse;

import com.github.javafaker.Faker;
import com.juliord24.springDataJPACourse.models.Author;
import com.juliord24.springDataJPACourse.models.Video;
import com.juliord24.springDataJPACourse.repositories.AuthorRepository;
import com.juliord24.springDataJPACourse.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaCourseApplication.class, args);
	}

	// Este es un bean que se ejecuta al inicio de la aplicacion
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository
	){
		return args -> {
			Faker faker = new Faker();
			for (int i = 0; i < 50; i++) {
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.leagueOfLegends().champion())
						.build();
				 authorRepository.save(author);
			}
		};

	}
}
