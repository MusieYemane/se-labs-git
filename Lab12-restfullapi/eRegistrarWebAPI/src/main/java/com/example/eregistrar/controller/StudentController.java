package com.example.eregistrar.controller;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:81"}, allowedHeaders = "*")
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)     //rest api always returns json data
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping(value="/list")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }



    @PostMapping(value= "/register")
    public Student addStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping(value="/get/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }


    @PutMapping(value= "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody Student student, @PathVariable Long studentId){
        return studentService.updateStudent(student, studentId);
    }

    @DeleteMapping(value= "/delete/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
    }


}
