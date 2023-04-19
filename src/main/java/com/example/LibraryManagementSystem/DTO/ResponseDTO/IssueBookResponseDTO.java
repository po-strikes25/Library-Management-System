package com.example.LibraryManagementSystem.DTO.ResponseDTO;

import com.example.LibraryManagementSystem.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDTO {
    private String transaction_no;
    private TransactionStatus transaction_status;
    private String book_name;
}