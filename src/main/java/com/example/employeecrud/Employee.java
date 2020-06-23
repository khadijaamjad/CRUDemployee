package com.example.employeecrud;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Employee implements Serializable {
    int empID,age;
    String name;
    float salary;
    boolean married;

    public Employee(int empID, int age, String name, float salary, boolean married) {
        this.empID = empID;
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return empID;
    }

    public boolean matches(@Nullable Object obj){
        if(!(obj instanceof Employee)){
            return false;
        }
        Employee em=(Employee)obj;
        return em.empID==this.empID;
    }
}

