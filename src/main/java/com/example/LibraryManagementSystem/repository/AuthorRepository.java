package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // ORM gives the implementation of findByCustomKey here ;
    Author findByEmail(String email);
}
