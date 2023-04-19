package com.example.LibraryManagementSystem.entity;

import com.example.LibraryManagementSystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issue_date;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String validity;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> books_issued = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transactions> transaction_list = new ArrayList<>();

}
