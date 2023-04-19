package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.DTO.ResponseDTO.AuthorResponseDTO;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public String addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    // 1. deleteAuthorById ;
    // 2. updateAuthorById ;
    // 3. findAuthorById ;
    // 4. findAllAuthors ;

    // 5. findAuthorByName ;
    @GetMapping("/get-author-by-email")
    public AuthorResponseDTO getAuthorByEmail(@RequestParam("email") String author_email) throws AuthorNotFoundException {
        return authorService.getAuthorByEmail(author_email);
    }

    // 6. getAllAuthorsOfParticularAge ;
}
