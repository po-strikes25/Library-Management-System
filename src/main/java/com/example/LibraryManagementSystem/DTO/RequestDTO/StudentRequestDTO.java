package com.example.LibraryManagementSystem.DTO.RequestDTO;

import com.example.LibraryManagementSystem.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDTO {

    private String name;

    private int age;

    private String mob_no;

    private Department dept;
}
