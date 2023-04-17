package com.example.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // name, age, and email will be taken as input from Postman ;

    private String name;

    private int age;

    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    /*
        If I do not initialize the ArrayList NullPointerException will be encountered ;
        Therefore, we initialize the collection Framework ;
    */
    private List<Book> book = new ArrayList<>();

}
