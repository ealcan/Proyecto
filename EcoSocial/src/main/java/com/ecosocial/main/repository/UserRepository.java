package com.ecosocial.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecosocial.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Métodos personalizados si es necesario
}

