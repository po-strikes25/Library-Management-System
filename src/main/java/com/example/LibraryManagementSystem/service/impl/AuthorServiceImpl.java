package com.example.LibraryManagementSystem.service.impl;

import com.example.LibraryManagementSystem.DTO.ResponseDTO.AuthorResponseDTO;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.exceptions.AuthorNotFoundException;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author Added";
    }

    @Override
    public AuthorResponseDTO getAuthorByEmail(String author_email) throws AuthorNotFoundException {

        Author authors;
        try {
            // Critical statement ;
            authors = authorRepository.findByEmail(author_email);

            // Preparing ResponseDTO here :
            AuthorResponseDTO authorResponseOutput = new AuthorResponseDTO();
            authorResponseOutput.setName(authors.getName());
            authorResponseOutput.setAge(authors.getAge());

            return authorResponseOutput;

        } catch (RuntimeException e) {
            throw new AuthorNotFoundException("Author Not Found");
        }
    }
}
