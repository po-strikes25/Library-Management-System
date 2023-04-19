package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.DTO.RequestDTO.IssueBookRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.IssueBookResponseDTO;
import com.example.LibraryManagementSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public IssueBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO){
        return transactionService.issueBook(issueBookRequestDTO);
    }
}
