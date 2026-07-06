package com.jdbc.util;

import com.jdbc.dto.StudentDTO;
import com.jdbc.enums.Course;
import com.jdbc.enums.Gender;
import com.jdbc.enums.Grade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);
    public static StudentDTO getStudentDetails() {
        StudentDTO student = new StudentDTO();
        System.out.print("Enter Student ID : ");
        student.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter First Name : ");
        student.setFirstName(sc.nextLine());
        System.out.print("Enter Last Name : ");
        student.setLastName(sc.nextLine());
        System.out.print("Enter Gender (MALE/FEMALE/OTHER) : ");
        student.setGender(Gender.valueOf(sc.nextLine().toUpperCase()));
        System.out.print("Enter City : ");
        student.setCity(sc.nextLine());
        System.out.print("Enter State : ");
        student.setState(sc.nextLine());
        System.out.print("Enter Mobile Number : ");
        student.setMobileNumber(sc.nextLine());
        System.out.print("Enter Email ID : ");
        student.setEmailId(sc.nextLine());
        System.out.print("Enter Course ID : ");
        student.setCourseId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Course Name : ");
        student.setCourseName(sc.nextLine());
        System.out.print("Enter Enrollment Date (dd-MM-yyyy) : ");
        String date = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        student.setEnrollmentDate(LocalDate.parse(date, formatter));
        System.out.print("Enter Course Type (ONLINE/OFFLINE/HYBRID) : ");
        student.setCourseType(Course.valueOf(sc.nextLine().toUpperCase()));
        System.out.print("Enter Grade (A/B/C/D/F) : ");
        student.setGrade(Grade.valueOf(sc.nextLine().toUpperCase()));
        return student;
    }

    public static int getStudentId() {
        System.out.print("Enter Student ID : ");
        return sc.nextInt();
    }

    public static String getEmailId() {
        sc.nextLine();
        System.out.print("Enter Email ID : ");
        return sc.nextLine();
    }

    public static LocalDate getEnrollmentDate() {
        System.out.print("Enter Enrollment Date (dd-MM-yyyy) : ");
        String date = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static String getCourseName() {
        sc.nextLine();
        System.out.print("Enter New Course Name : ");
        return sc.nextLine();
    }
}