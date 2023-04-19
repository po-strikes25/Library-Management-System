package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.DTO.RequestDTO.IssueBookRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.IssueBookResponseDTO;

public interface TransactionService {
    public IssueBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO);
}
