package com.springio.test;

import com.springio.test.domain.Basic;
import com.springio.test.domain.Profile;
import com.springio.test.repository.BasicRepository;
import com.springio.test.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 5).forEach(index ->
					profileRepository.save(Profile.builder()
						.network("소셜 네트워크" + index)
						.username("유저 이름" + index)
						.url("https://www." + index + ".com")
						.createdAt(LocalDateTime.now())
						.updateDate(LocalDateTime.now()).build())
			);
			IntStream.rangeClosed(1, 5).forEach(index ->
					basicRepository.save(Basic.builder()
							.name("이름" + index)
							.label("직책" + index)
							.email("email" + index + "@gmail.com")
							.phone("010-1234-567" + index).build())
			);
		};
	}


}
