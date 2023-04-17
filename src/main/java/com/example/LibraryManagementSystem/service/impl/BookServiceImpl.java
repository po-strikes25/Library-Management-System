package com.example.LibraryManagementSystem.service.impl;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.service.AuthorService;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws RuntimeException {

        Author author;

        // Since it is not known whether the author is present in the database or not :
        try {
            // Remember .get() is outside () ;
            // How .getAuthor() is working is only the id parameter has been passed by the user via postman ;
            author = authorRepository.findById(book.getAuthor().getId()).get();
        } catch (Exception e) {
            throw new RuntimeException("Author not present in the database");
        }

        // Getting the list of books written by the author and inserting the new_book into the list :
        author.getBook().add(book);
        book.setAuthor(author);

        authorRepository.save(author);

        return "Book Added";
    }
}
