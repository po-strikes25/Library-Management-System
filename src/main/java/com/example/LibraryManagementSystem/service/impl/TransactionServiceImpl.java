package com.example.LibraryManagementSystem.service.impl;

import com.example.LibraryManagementSystem.DTO.RequestDTO.IssueBookRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.IssueBookResponseDTO;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Card;
import com.example.LibraryManagementSystem.entity.Transactions;
import com.example.LibraryManagementSystem.enums.Status;
import com.example.LibraryManagementSystem.enums.TransactionStatus;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.repository.CardRepository;
import com.example.LibraryManagementSystem.repository.TransactionRepository;
import com.example.LibraryManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    JavaMailSender emailSender;

    @Override
    public IssueBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO) {

        Transactions transaction = new Transactions();
        // Very important on how to extract unique transaction Id using UUID :
        transaction.setTransaction_no(String.valueOf(UUID.randomUUID()));
        transaction.setIssue(true);

        Card card;

        try{
            card = cardRepository.findById(issueBookRequestDTO.getCard_id()).get();
        } catch(RuntimeException e) {
            transaction.setTransaction_status(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("Card does not exist");
        }
        transaction.setCard(card);

        Book book;

        try{
            book = bookRepository.findById(issueBookRequestDTO.getBook_id()).get();
        } catch(RuntimeException e) {
            transaction.setTransaction_status(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("Book does not exist");
        }
        transaction.setBook(book);

        if(card.getStatus() != Status.ACTIVE) {
            transaction.setTransaction_status(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("Card is not Activated");
        }

        if(book.isIssued()) {
            transaction.setTransaction_status(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("Book is not Available");
        }

        transaction.setTransaction_status(TransactionStatus.SUCCESS);

        book.setIssued(true);
        book.setCard(card);
        book.getTransaction_list().add(transaction);

        card.getBooks_issued().add(book);
        card.getTransaction_list().add(transaction);

        cardRepository.save(card);

        // Preparing Response DTO here ;
        IssueBookResponseDTO issueBookResponseOutput = new IssueBookResponseDTO();
        issueBookResponseOutput.setBook_name(book.getTitle());
        issueBookResponseOutput.setTransaction_status(transaction.getTransaction_status());
        issueBookResponseOutput.setTransaction_no(transaction.getTransaction_no());

        // Sending email to the issuer :

        String text = "Congrats!" + card.getStudent().getName() + "You have been issued the book" + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rue.eun.woo.26@gmail.com");
        message.setTo(card.getStudent().getMob_no());
        message.setSubject("Issue Book");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseOutput;
    }

    // 2. Return Book API

}
