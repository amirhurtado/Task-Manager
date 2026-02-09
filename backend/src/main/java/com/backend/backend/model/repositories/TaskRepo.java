package com.backend.backend.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.entities.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
    
}
