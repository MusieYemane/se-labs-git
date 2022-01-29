package com.example.eregistrar.service;

import com.example.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    Student saveStudent(Student student);
    Student updateStudent(Student student, Long studentId);
    void deleteStudentById(Long studentId);
    List<Student> searchStudents(String searchString);
}
