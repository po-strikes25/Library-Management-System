package com.example.LibraryManagementSystem.DTO.ResponseDTO;

import com.example.LibraryManagementSystem.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDTO {
    private int id;

    private String name;

    private int age;

    private int mob_no;

    private Department dept;

    private CardResponseDTO cardDTO;
}
