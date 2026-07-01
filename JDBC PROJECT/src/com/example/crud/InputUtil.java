package com.example.crud;
import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;



public class InputUtil {
    private static String Dbname;

    public static String createDB(Scanner sc) {
        String db=sc .nextLine();
        Dbname=db;
        return db;
    }

    public static String getDbname() {
        return Dbname;
    }
    public static Student getStudent(Scanner sc){
            Student s = new Student();
            System.out.println("Enter id:");
            s.setId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter regno:");
            s.setRegno(sc.nextLine());
            System.out.println("Enter name:");
            s.setName(sc.nextLine());
            System.out.println("Enter dept:");
            s.setDept(sc.nextLine());
            System.out.println("Enter email:");
            s.setEmail(sc.nextLine());
            return s;
    }
}
