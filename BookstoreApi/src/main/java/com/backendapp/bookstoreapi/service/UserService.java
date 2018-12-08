package com.backendapp.bookstoreapi.service;

import java.util.Set;

import com.backendapp.bookstoreapi.domain.User;
import com.backendapp.bookstoreapi.domain.security.UserRole;

public interface UserService {

	User createUser(User user1, Set<UserRole> userRoles);

}
