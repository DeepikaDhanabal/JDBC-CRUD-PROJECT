package com.example.crud;

public interface Service {
    void createDatabase(String dbname);
    void createTable();
    void insertData(Student student);
    void delete(String regno,String name);
    void update();
    void findAll();
}
