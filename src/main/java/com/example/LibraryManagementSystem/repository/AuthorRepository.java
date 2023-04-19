package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // ORM gives the implementation of findByCustomKey here ;
    Author findByEmail(String email);
}
