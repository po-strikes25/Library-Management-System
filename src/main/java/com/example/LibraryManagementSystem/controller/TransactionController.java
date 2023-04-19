package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.DTO.RequestDTO.IssueBookRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.IssueBookResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {


    public IssueBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO){
        
    }
}
