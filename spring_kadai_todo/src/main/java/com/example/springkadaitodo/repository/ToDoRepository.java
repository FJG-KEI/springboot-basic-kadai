package com.example.springkadaitodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkadaitodo.entity.Todo;

public interface ToDoRepository extends JpaRepository<Todo, Integer> {
	
}
