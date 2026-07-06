package com.jdbc.service.impl;

import com.jdbc.dto.StudentDTO;
import com.jdbc.exception.DuplicateStudentException;
import com.jdbc.exception.StudentNotFoundException;
import com.jdbc.repository.StudentRepository;
import com.jdbc.repository.impl.StudentRepositoryImpl;
import com.jdbc.service.StudentService;

import java.time.LocalDate;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public void addStudent(StudentDTO student) {

        StudentDTO existing = repository.getStudentById(student.getId());

        if (existing != null) {
            throw new DuplicateStudentException("Student already exists.");
        }

        repository.addStudent(student);
    }

    @Override
    public StudentDTO getStudentById(int id) {

        StudentDTO student = repository.getStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException("Student Not Found");
        }

        return student;
    }

    @Override
    public void updateCourse(StudentDTO student) {

        StudentDTO existing = repository.getStudentById(student.getId());

        if (existing == null) {
            throw new StudentNotFoundException("Student Not Found");
        }

        repository.updateCourse(student);
    }

    @Override
    public void deleteStudent(int id) {

        StudentDTO existing = repository.getStudentById(id);

        if (existing == null) {
            throw new StudentNotFoundException("Student Not Found");
        }

        repository.deleteStudent(id);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return repository.getAllStudents();
    }

    @Override
    public StudentDTO getStudentByEmailAndDate(String emailId, LocalDate enrollmentDate) {

        StudentDTO student =
                repository.getStudentByEmailAndDate(emailId, enrollmentDate);

        if (student == null) {
            throw new StudentNotFoundException("Student Not Found");
        }

        return student;
    }
}