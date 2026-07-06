package com.jdbc.util;

import com.jdbc.dto.StudentDTO;
import com.jdbc.enums.Course;
import com.jdbc.enums.Gender;
import com.jdbc.enums.Grade;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtil {
    public static StudentDTO convertStudentResultSetToDto(ResultSet rs) throws SQLException {
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
        return student;
    }
}