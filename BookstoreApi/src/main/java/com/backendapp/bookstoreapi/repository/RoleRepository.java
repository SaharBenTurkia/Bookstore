package com.backendapp.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendapp.bookstoreapi.model.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
