package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.DTO.ResponseDTO.AuthorResponseDTO;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.exceptions.AuthorNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDTO getAuthorByEmail(String author_email) throws AuthorNotFoundException;

}
