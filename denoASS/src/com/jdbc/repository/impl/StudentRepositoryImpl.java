package com.jdbc.repository.impl;

import com.jdbc.dto.StudentDTO;
import com.jdbc.enums.Course;
import com.jdbc.enums.Gender;
import com.jdbc.enums.Grade;
import com.jdbc.exception.InternalServiceException;
import com.jdbc.repository.StudentRepository;
import com.jdbc.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void addStudent(StudentDTO student) {

        String sql = "INSERT INTO students VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getGender().toString());
            ps.setString(5, student.getCity());
            ps.setString(6, student.getState());
            ps.setString(7, student.getMobileNumber());
            ps.setString(8, student.getEmailId());
            ps.setInt(9, student.getCourseId());
            ps.setString(10, student.getCourseName());
            ps.setDate(11, Date.valueOf(student.getEnrollmentDate()));
            ps.setString(12, student.getCourseType().toString());
            ps.setString(13, student.getGrade().toString());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new InternalServiceException(e.getMessage());
        }
    }

    @Override
    public StudentDTO getStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id=?";

        StudentDTO student = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new StudentDTO();

                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGender(Gender.valueOf(rs.getString("gender")));
                student.setCity(rs.getString("city"));
                student.setState(rs.getString("state"));
                student.setMobileNumber(rs.getString("mobile_number"));
                student.setEmailId(rs.getString("email_id"));
                student.setCourseId(rs.getInt("course_id"));
                student.setCourseName(rs.getString("course_name"));
                student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
                student.setCourseType(Course.valueOf(rs.getString("course_type")));
                student.setGrade(Grade.valueOf(rs.getString("grade")));
            }

        } catch (SQLException e) {
            throw new InternalServiceException(e.getMessage());
        }

        return student;
    }

    @Override
    public boolean updateCourse(StudentDTO student) {

        String sql = "UPDATE students SET course_id=?, course_name=?, course_type=?, grade=? WHERE id=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, student.getCourseId());
            ps.setString(2, student.getCourseName());
            ps.setString(3, student.getCourseType().toString());
            ps.setString(4, student.getGrade().toString());
            ps.setInt(5, student.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new InternalServiceException(e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new InternalServiceException(e.getMessage());
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        String sql = "SELECT * FROM students";

        List<StudentDTO> studentList = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                StudentDTO student = new StudentDTO();

                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGender(Gender.valueOf(rs.getString("gender")));
                student.setCity(rs.getString("city"));
                student.setState(rs.getString("state"));
                student.setMobileNumber(rs.getString("mobile_number"));
                student.setEmailId(rs.getString("email_id"));
                student.setCourseId(rs.getInt("course_id"));
                student.setCourseName(rs.getString("course_name"));
                student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
                student.setCourseType(Course.valueOf(rs.getString("course_type")));
                student.setGrade(Grade.valueOf(rs.getString("grade")));

                studentList.add(student);
            }

        } catch (SQLException e) {
            throw new InternalServiceException(e.getMessage());
        }

        return studentList;
    }

    @Override
    public StudentDTO getStudentByEmailAndDate(String email, LocalDate enrollmentDate) {

        String sql = "SELECT * FROM students WHERE email_id=? AND enrollment_date=?";

        StudentDTO student = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setDate(2, Date.valueOf(enrollmentDate));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new StudentDTO();

                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGender(Gender.valueOf(rs.getString("gender")));
                student.setCity(rs.getString("city"));
                student.setState(rs.getString("state"));
                student.setMobileNumber(rs.getString("mobile_number"));
                student.setEmailId(rs.getString("email_id"));
                student.setCourseId(rs.getInt("course_id"));
                student.setCourseName(rs.getString("course_name"));
                student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
                student.setCourseType(Course.valueOf(rs.getString("course_type")));
                student.setGrade(Grade.valueOf(rs.getString("grade")));
            }

        } catch (SQLException e) {
            throw new InternalServiceException(e.getMessage());
        }

        return student;
    }
}