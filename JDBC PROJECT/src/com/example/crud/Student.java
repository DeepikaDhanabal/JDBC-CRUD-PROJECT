package com.example.crud;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString


public class Student {
    private static int id;
    private String regno;
    private String name;
    private String dept;
    private String email;



    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
