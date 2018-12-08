package com.backendapp.bookstoreapi;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backendapp.bookstoreapi.config.SecurityUtility;
import com.backendapp.bookstoreapi.domain.User;
import com.backendapp.bookstoreapi.domain.security.Role;
import com.backendapp.bookstoreapi.domain.security.UserRole;
import com.backendapp.bookstoreapi.service.UserService;

@SpringBootApplication
public class BookstoreApiApplication implements CommandLineRunner {

	@Autowired 
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		User user1 = new User();
		user1.setFirstname("sahar");
		user1.setLastname("BT");
		user1.setUsername("SaharBT");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("benturkia.sahar@gmail.com");
		
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user1,role1));
		
		userService.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstname("Admin");
		user2.setLastname("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("benturkia.sahar@gmail.com");
		
		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setName("ROLE_ADMIN");
		
		userRoles.add(new UserRole(user2,role2));
		
		userService.createUser(user2, userRoles);
	}
}
