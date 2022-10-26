package com.novare.natflix;

import com.novare.natflix.Repository.UserRepository;
import com.novare.natflix.Service.ContentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class NatflixApplication {
	public static void main(String[] args) {
		SpringApplication.run(NatflixApplication.class, args);
	}

}
