package com.example.LibraryManagementSystem.service.impl;

import com.example.LibraryManagementSystem.DTO.RequestDTO.StudentRequestDTO;
import com.example.LibraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.UpdateStudentMobileResponseDTO;
import com.example.LibraryManagementSystem.entity.Card;
import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.enums.Status;
import com.example.LibraryManagementSystem.exceptions.StudentNotFoundException;
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
    public String addStudent(StudentRequestDTO studentRequestDTO) {
        // Since card value is not obtained by the user, hence we do it manually here :
        // Generating a new card for the new student :
        /* Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidity("2024-01-31");
        card.setStudent(student);

        // Allocate the card to a specific student :
        student.setCard(card);

        // Add the student to repository :
        studentRepository.save(student);

        return "Student Added";
        */

        // Converting studentRequestDTO to Student object for storing into the Database :
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setMob_no(studentRequestDTO.getMob_no());
        student.setDept(studentRequestDTO.getDept());

        Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidity("2024-01-31");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student Added";
    }

    @Override
    public UpdateStudentMobileResponseDTO updateMobile(UpdateStudentMobileRequestDTO updateStudentMobile) throws StudentNotFoundException {

        try {
            Student student = studentRepository.findById(updateStudentMobile.getId()).get();

            // In-place updation ;
            student.setMob_no(updateStudentMobile.getMobile_no());
            Student updatedStudent = studentRepository.save(student);

            // Preparing Response DTO here ;
            UpdateStudentMobileResponseDTO updatedStudentOutput = new UpdateStudentMobileResponseDTO();
            updatedStudentOutput.setMobile_No(updatedStudent.getMob_no());
            updatedStudentOutput.setName(updatedStudent.getName());

            return updatedStudentOutput;

        } catch(Exception e) {
            throw new StudentNotFoundException("Invalid Student ID");
        }
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }
}
