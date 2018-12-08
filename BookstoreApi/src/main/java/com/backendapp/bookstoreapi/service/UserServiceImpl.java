package com.backendapp.bookstoreapi.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backendapp.bookstoreapi.domain.User;
import com.backendapp.bookstoreapi.domain.security.UserRole;
import com.backendapp.bookstoreapi.repository.RoleRepository;
import com.backendapp.bookstoreapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if (localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			for (UserRole userRole : userRoles) {
				roleRepository.save(userRole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			
			localUser = userRepository.save(user);
		}
		return localUser;
	}

}
