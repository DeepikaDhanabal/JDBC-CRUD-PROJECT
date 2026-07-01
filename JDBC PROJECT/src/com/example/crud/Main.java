package com.example.crud;

import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            Service service = new ServiceImpl();
            while (true) {
                System.out.println(" Welcome to the CRUD API");
                System.out.println("1.Create Database");
                System.out.println("2.Create Table");
                System.out.println("3.insert data");
                System.out.println("4.update data");
                System.out.println("5.delete data");
                System.out.println("6.retrive data");
                System.out.println("7.exit");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                sc.nextLine();


                switch (choice) {
                    case 1:
                        System.out.println("Enter the name of database:");
                        String Dbname = InputUtil.createDB(sc);
                        service.createDatabase(Dbname);
                        break;
                    case 2:
                        service.createTable();
                        break;
                    case 3:
                        Student s = InputUtil.getStudent(sc);
                        service.insertData(s);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        service.findAll();
                        break;
                    case 7:
                        System.exit(0);


                }


            }

        }
    }
}
