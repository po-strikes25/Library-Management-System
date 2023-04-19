package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.DTO.RequestDTO.StudentRequestDTO;
import com.example.LibraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.UpdateStudentMobileResponseDTO;
import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.exceptions.StudentNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentService {
    public String addStudent(StudentRequestDTO studentRequestDTO);

    public UpdateStudentMobileResponseDTO updateMobile(UpdateStudentMobileRequestDTO updateStudentMobile) throws StudentNotFoundException;

    public Student getStudentById(int id) throws StudentNotFoundException;
}
