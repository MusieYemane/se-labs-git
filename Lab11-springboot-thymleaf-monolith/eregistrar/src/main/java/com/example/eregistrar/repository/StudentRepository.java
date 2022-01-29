package com.example.eregistrar.repository;

import com.example.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value="select s from Student s where s.studentNumber=:studentNo or s.firstName=:firstName or s.lastName=:lastName")
    List<Student> findAllByStudentNoOrFirstNameOrLastName(String studentNo, String firstName, String lastName);

}
