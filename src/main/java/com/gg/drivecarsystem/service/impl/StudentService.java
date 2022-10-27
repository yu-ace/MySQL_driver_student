package com.gg.drivecarsystem.service.impl;

import com.gg.drivecarsystem.model.Student;
import com.gg.drivecarsystem.service.IStudentService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{

    private static StudentService studentService =new StudentService();
    private StudentService(){
    }
    public static StudentService getInstance(){
        return studentService;
    }

    @Override
    public void newStudent(String name) {
        try{
            String tmp = "insert into student (name) values ('%s');";
            String sqlStr =String.format(tmp,name);
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void glass(int id, int n, int grade) {
        try{
            String tmp = "update student set `%d` = %d where id = %d";
            String sqlStr = String.format(tmp,n,grade,id);
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public double[] ave() {
       double[] ave = new double[4];
       try{
           String mysql = "select avg(`1`),avg(`2`),avg(`3`),avg(`4`) from student;";
           Connection connection = DriverManager
                   .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
           PreparedStatement preparedStatement = connection.prepareStatement(mysql);
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           ave[0] = resultSet.getDouble(1);
           ave[1] = resultSet.getDouble(2);
           ave[2] = resultSet.getDouble(3);
           ave[3] = resultSet.getDouble(4);
           connection.close();
       }catch(Exception e){
           e.printStackTrace();
       }
       return ave;
    }

    @Override
    public Student[] max() {
        Student[] students = new Student[4];
        String tmp = "select * from student order by `%d`;";
        for(int i = 1;i < 5;i++){
            try{
                String sqlStr = String.format(tmp,i);
                Connection connection = DriverManager
                     .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int n1 = resultSet.getInt("1");
                    int n2 = resultSet.getInt("2");
                    int n3 = resultSet.getInt("3");
                    int n4 = resultSet.getInt("4");
                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setClass1(n1);
                    student.setClass2(n2);
                    student.setClass3(n3);
                    student.setClass4(n4);
                    students[i - 1] = student;
                }
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
            return students;
    }

    @Override
    public Student[] min() {
        Student[] students = new Student[4];
        String tmp = "select * from student order by `%d` desc;";
        for(int i = 1;i < 5;i++){
            try{
                String mysql = String.format(tmp,i);
                Connection connection = DriverManager
                     .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
                PreparedStatement preparedStatement = connection.prepareStatement(mysql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int n1 = resultSet.getInt("1");
                    int n2 = resultSet.getInt("2");
                    int n3 = resultSet.getInt("3");
                    int n4 = resultSet.getInt("4");
                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setClass1(n1);
                    student.setClass2(n2);
                    student.setClass3(n3);
                    student.setClass4(n4);
                    students[i - 1] = student;
                }
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        try{
            String mysql = "select * from student;";
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement(mysql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int n1 = resultSet.getInt("1");
                int n2 = resultSet.getInt("2");
                int n3 = resultSet.getInt("3");
                int n4 = resultSet.getInt("4");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setClass1(n1);
                student.setClass2(n2);
                student.setClass3(n3);
                student.setClass4(n4);
                studentList.add(student);
            }
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<Student> passed() {
        List<Student> passed = new ArrayList<>();
        try{
            String mysql = "select * from student where (`1` >= 90 and `2` >= 90 and `3` >= 90 and `4` >= 90);";
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.50.252:3306/drive_student","root","123456");
            PreparedStatement preparedStatement = connection.prepareStatement(mysql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int n1 = resultSet.getInt("1");
                int n2 = resultSet.getInt("2");
                int n3 = resultSet.getInt("3");
                int n4 = resultSet.getInt("4");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setClass1(n1);
                student.setClass2(n2);
                student.setClass3(n3);
                student.setClass4(n4);
                passed.add(student);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       return passed;
    }
}
