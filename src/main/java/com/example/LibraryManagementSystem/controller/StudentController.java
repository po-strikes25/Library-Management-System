package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.DTO.RequestDTO.StudentRequestDTO;
import com.example.LibraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileRequestDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.StudentResponseDTO;
import com.example.LibraryManagementSystem.DTO.ResponseDTO.UpdateStudentMobileResponseDTO;
import com.example.LibraryManagementSystem.entity.Student;
import com.example.LibraryManagementSystem.exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystem.service.StudentService;
import com.example.LibraryManagementSystem.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    /*  Careful here : Take the object of the Service Interface and NOT Service class !!!
        Here object of an Interface can be created as the Implementation of this Interface has been written !
    */
    StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.addStudent(studentRequestDTO);
    }

    @PutMapping("/update-mobile")
    public UpdateStudentMobileResponseDTO updateMobile(@RequestBody UpdateStudentMobileRequestDTO updateStudentMobile) throws StudentNotFoundException {
        return studentService.updateMobile(updateStudentMobile);
    }

    // 1. deleteStudentById ;
    // 2. updateStudentById ;
    // 3. findStudentById ;

    // Getting StackOverFlowError by using this API !!!! DTO required here !!!
    @GetMapping("/get-student")
    public StudentResponseDTO getStudentById(@RequestParam("id") int id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }

    // 4. findAllStudents ;
}
