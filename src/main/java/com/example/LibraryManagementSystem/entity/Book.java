package com.example.LibraryManagementSystem.entity;

import com.example.LibraryManagementSystem.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //private String publication;

    private int no_of_pages;

    private int price;

    private boolean issued = false;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    // Since Book is a child class hence @JoinColumn
    @JoinColumn
    private Card card;

    // Since Book is a parent class hence no @JoinColumn but mappedBy and cascade :
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transactions> transaction_list = new ArrayList<>();
}
