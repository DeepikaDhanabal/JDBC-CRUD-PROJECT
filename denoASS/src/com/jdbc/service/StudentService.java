package com.jdbc.service;

import com.jdbc.dto.StudentDTO;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    void addStudent(StudentDTO student);

    StudentDTO getStudentById(int id);

    void updateCourse(StudentDTO student);

    void deleteStudent(int id);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentByEmailAndDate(String emailId, LocalDate enrollmentDate);
}