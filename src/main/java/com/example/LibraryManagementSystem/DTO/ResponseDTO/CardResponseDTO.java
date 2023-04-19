package com.example.LibraryManagementSystem.DTO.ResponseDTO;

import com.example.LibraryManagementSystem.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardResponseDTO {
    private int id;

    private Date issue_date;

    private Date updatedOn;

    private Status status;

    private String validity;
}
