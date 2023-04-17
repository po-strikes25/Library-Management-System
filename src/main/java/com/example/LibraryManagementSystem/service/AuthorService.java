package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.entity.Author;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorService {

    public String addAuthor(Author author);

}
