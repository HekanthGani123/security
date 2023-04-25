package com.jwt.security;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jwt.security.entity.User;
import com.jwt.security.repository.UserRepository;

@SpringBootApplication
public class SecurityApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(5965, "hekanth", "tiger", "hekanth@gmail.com"),
				new User(5966, "Ananda", "rat", "ananda@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
