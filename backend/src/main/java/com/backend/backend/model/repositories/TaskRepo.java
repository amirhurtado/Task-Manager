package com.backend.backend.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.model.entities.Task;


@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    
}
