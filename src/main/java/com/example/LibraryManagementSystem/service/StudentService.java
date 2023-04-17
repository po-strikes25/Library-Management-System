package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.entity.Student;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentService {
    public String addStudent(Student student);
}
