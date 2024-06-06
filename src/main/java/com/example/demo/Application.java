package com.example.demo;

import com.example.demo.enity.Role;
import com.example.demo.enity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void initAdmin() {
		Role role = new Role();
		role.setName("ADMIN");


		User user = new User();
		user.setLogin("82222222222")
				.setPassword(passwordEncoder.encode("111"))
				.setRoles(Set.of(roleRepository.save(role)))
				.setFirstName("Gleb")
				.setMiddleName("Pec")
				.setBirthday("11.11.2011")
				.setLastName("Nik")
				.setGender("m")
				.setRub(1000L)
				.setEmail("222@mail.ru");

		userRepository.save(user) ;
	}
}
