package com.example.LibraryManagementSystem.entity;

import com.example.LibraryManagementSystem.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private String mob_no;

    @Enumerated(EnumType.STRING)
    private Department dept;

    // Cascade : Applying all CRUD operations on CHILD as well;
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;

}
