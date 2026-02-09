package com.backend.backend.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
}
