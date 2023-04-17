package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.service.AuthorService;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public String addBook(@RequestBody Book book) throws RuntimeException {
        return bookService.addBook(book);
    }

    // 1. findAllBooks ;
    // 2. findAllBooksOfSpecificAuthorId ;
    // 3. findNumberOfBooksByAuthorId ;
}
