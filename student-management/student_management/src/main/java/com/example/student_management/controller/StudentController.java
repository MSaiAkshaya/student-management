package com.example.student_management.controller;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE STUDENT
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student savedStudent = service.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // GET ALL STUDENTS
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // GET STUDENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = service.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // UPDATE STUDENT
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @Valid @RequestBody Student student) {
        Student updatedStudent = service.updateStudent(id, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // DELETE STUDENT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}