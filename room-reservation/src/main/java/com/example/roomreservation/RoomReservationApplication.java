package com.example.roomreservation;

import com.example.roomreservation.models.User;
import com.example.roomreservation.models.UserRole;
import com.example.roomreservation.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class RoomReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomReservationApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	// save data in DB for users, roles, roles to users
	@Bean
	CommandLineRunner run (UserService userService) {
		return args -> {
			userService.saveUserRole(new UserRole(null,"ROLE_USER"));
			userService.saveUserRole(new UserRole(null,"ROLE_MANAGER"));
			userService.saveUserRole(new UserRole(null,"ROLE_ADMIN"));
			userService.saveUserRole(new UserRole(null,"ROLE_SUPER_ADMIN"));
			userService.saveUser(new User(null,"Eya Khlif","eya","123456", new ArrayList<>()));
			userService.addUserRoleToUser("eya","ROLE_USER");
			userService.addUserRoleToUser("eya","ROLE_MANAGER");
			userService.addUserRoleToUser("eya","ROLE_ADMIN");
		};
	}

}
