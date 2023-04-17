package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.service.StudentService;
import com.example.LibraryManagementSystem.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    /*  Careful here : Take the object of the Service Interface and NOT Service class !!!
        Here object of an Interface can be created as the Implementation of this Interface has been written !
    */
    StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // 1. deleteStudentById ;
    // 2. updateStudentById ;
    // 3. findStudentById ;
    // 4. findAllStudents ;
}
