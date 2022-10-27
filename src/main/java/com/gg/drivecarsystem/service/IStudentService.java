package com.gg.drivecarsystem.service;

import com.gg.drivecarsystem.model.Student;

import java.util.List;

public interface IStudentService {
    void newStudent(String name);
    void glass(int id,int n,int grade);
    double[] ave();
    Student[] max();
    Student[] min();
    List<Student> getStudentList();
    List<Student> passed();
}
