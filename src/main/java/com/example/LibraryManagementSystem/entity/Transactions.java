package com.example.LibraryManagementSystem.entity;

import com.example.LibraryManagementSystem.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transaction_no;

    @CreationTimestamp
    private Date transaction_date;

    private boolean isIssue;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transaction_status;

    // Including all the cardinal relationships here :
    @ManyToOne
    @JoinColumn
    private Card card;

    @ManyToOne
    @JoinColumn
    private Book book;
}
