package com.jdbc.dto;

import com.jdbc.enums.Course;
import com.jdbc.enums.Gender;
import com.jdbc.enums.Grade;

import java.time.LocalDate;

public class StudentDTO {

    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private int courseId;
    private String courseName;
    private LocalDate enrollmentDate;
    private Course course;
    private Grade grade;

    // Default Constructor
    public StudentDTO() {
    }

    // Parameterized Constructor
    public StudentDTO(int id, String firstName, String lastName,
                      Gender gender, String city, String state,
                      String mobileNumber, String emailId,
                      int courseId, String courseName,
                      LocalDate enrollmentDate, Course course,
                      Grade grade) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
        this.state = state;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrollmentDate = enrollmentDate;
        this.course = course;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Course getCourseType() {
        return course;
    }

    public void setCourseType(Course course) {
        this.course = course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }
}