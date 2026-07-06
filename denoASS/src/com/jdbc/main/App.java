package com.jdbc.main;

import com.jdbc.dto.StudentDTO;
import com.jdbc.service.StudentService;
import com.jdbc.service.impl.StudentServiceImpl;
import com.jdbc.util.InputUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentServiceImpl();

        while (true) {

            System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add new student with course enrollment details");
            System.out.println("2. Fetch student details by student id");
            System.out.println("3. Update course details of a student");
            System.out.println("4. Delete a student record");
            System.out.println("5. Fetch all students");
            System.out.println("6. Fetch student by email id and enrollment date");
            System.out.println("7. Exit");
            System.out.print("Enter your choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    StudentDTO student = InputUtil.getStudentDetails();
                    service.addStudent(student);
                    System.out.println("Student Added Successfully");
                    break;

                case 2:

                    int id = InputUtil.getStudentId();

                    StudentDTO result = service.getStudentById(id);

                    if (result != null) {
                        System.out.println(result);
                    } else {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 3:

                    int studentId = InputUtil.getStudentId();

                    StudentDTO updateStudent = service.getStudentById(studentId);

                    if (updateStudent != null) {

                        System.out.print("Enter New Course ID : ");
                        updateStudent.setCourseId(sc.nextInt());

                        sc.nextLine();

                        System.out.print("Enter New Course Name : ");
                        updateStudent.setCourseName(sc.nextLine());

                        System.out.print("Enter Course Type : ");
                        updateStudent.setCourseType(
                                com.jdbc.enums.Course.valueOf(sc.nextLine().toUpperCase()));

                        System.out.print("Enter Grade : ");
                        updateStudent.setGrade(
                                com.jdbc.enums.Grade.valueOf(sc.nextLine().toUpperCase()));

                        service.updateCourse(updateStudent);

                        System.out.println("Course Updated Successfully");

                    } else {

                        System.out.println("Student Not Found");
                    }

                    break;

                case 4:

                    int deleteId = InputUtil.getStudentId();

                    service.deleteStudent(deleteId);

                    System.out.println("Student Deleted Successfully");

                    break;

                case 5:

                    List<StudentDTO> students = service.getAllStudents();

                    for (StudentDTO s : students) {

                        System.out.println(s);
                    }

                    break;

                case 6:

                    String email = InputUtil.getEmailId();

                    LocalDate date = InputUtil.getEnrollmentDate();

                    StudentDTO studentDTO =
                            service.getStudentByEmailAndDate(email, date);

                    if (studentDTO != null) {

                        System.out.println(studentDTO);

                    } else {

                        System.out.println("Student Not Found");
                    }

                    break;

                case 7:

                    System.out.println("Thank You...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}