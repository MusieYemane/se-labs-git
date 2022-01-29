package com.example.eregistrar.service;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student updatedStudent, Long studentId) {
        Student oldStudent= studentRepository.findById(studentId).orElseGet(null);
        if(oldStudent!=null){
            oldStudent.setFirstName(updatedStudent.getFirstName());
            oldStudent.setLastName(updatedStudent.getLastName());
            oldStudent.setMiddleName(updatedStudent.getMiddleName());
            oldStudent.setCgpa(updatedStudent.getCgpa());
            oldStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());
            oldStudent.setIsInternational(updatedStudent.getIsInternational());
        }else{
            System.out.println("Student not found");
            //throw an exception
        }
        return studentRepository.save(oldStudent);
    }


    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        return studentRepository.findAllByStudentNoOrFirstNameOrLastName(searchString, searchString, searchString);

    }
}
