package com.example.LibraryManagementSystem.service.impl;

import com.example.LibraryManagementSystem.entity.Card;
import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.enums.Status;
import com.example.LibraryManagementSystem.repository.StudentRepository;
import com.example.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {
        // Since card value is not obtained by the user, hence we do it manually here :
        // Generating a new card for the new student :
        Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidity("2024-01-31");
        card.setStudent(student);

        // Allocate the card to a specific student :
        student.setCard(card);

        // Add the student to repository :
        studentRepository.save(student);

        return "Student Added";
    }
}
