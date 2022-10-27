package com.gg.drivecarsystem;

import com.gg.drivecarsystem.model.Student;
import com.gg.drivecarsystem.service.IStudentService;
import com.gg.drivecarsystem.service.impl.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DriveCarSystemApplication implements CommandLineRunner {

    private Scanner scanner = new Scanner(System.in);

    private IStudentService studentService = StudentService.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(DriveCarSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        while(true){
            printHelp();
            String str = scanner.next();
            if(str.equals("1")){
                System.out.println("输入学生姓名");
                String name = scanner.next();
                studentService.newStudent(name);
            }else if(str.equals("2")){
                System.out.println("输入学生id");
                int id = scanner.nextInt();
                System.out.println("输入考试科目");
                int n = scanner.nextInt();
                System.out.println("输入考试成绩");
                int grade = scanner.nextInt();
                studentService.glass(id,n,grade);
            }else if(str.equals("3")){
                for(Student student : studentService.getStudentList()){
                    System.out.println(student.getId() + "\t" + student.getName() +  "\t" + student.getClass1()
                            + "\t" + student.getClass2() + "\t" + student.getClass3()
                            + "\t" + student.getClass4());
                }
            }else if(str.equals("4")){
                double ave[] = studentService.ave();
                for(int i = 0;i < ave.length;i++){
                    System.out.println(i + "\t" + ave[i]);
                }
            }else if(str.equals("5")){
                Student[] max = studentService.max();
                System.out.println("科一最高分:" + max[0].getClass1() + "由" + max[0].getName() +"创造");
                System.out.println("科二最高分:" + max[1].getClass2() + "由" + max[1].getName() +"创造");
                System.out.println("科三最高分:" + max[2].getClass3() + "由" + max[2].getName() +"创造");
                System.out.println("科四最高分:" + max[3].getClass4() + "由" + max[3].getName() +"创造");
            }else if(str.equals("6")){
                Student[] min = studentService.min();
                System.out.println("科一最低分:" + min[0].getClass1() + "由" + min[0].getName() +"创造");
                System.out.println("科二最低分:" + min[1].getClass2() + "由" + min[1].getName() +"创造");
                System.out.println("科三最低分:" + min[2].getClass3() + "由" + min[2].getName() +"创造");
                System.out.println("科四最低分:" + min[3].getClass4() + "由" + min[3].getName() +"创造");
            }else if(str.equals("7")){
                for(Student student : studentService.passed()){
                    System.out.println(student.getName());
                }
            }else if(str.equals("8")){
                System.exit(0);
            }
        }
    }

    public void printHelp(){
        System.out.println("欢迎使用驾校管理系统");
        System.out.println("输入1 学员入学");
        System.out.println("输入2 录入学员成绩");
        System.out.println("输入3 查看学员列表");
        System.out.println("输入4 查看各个科目考试平均分");
        System.out.println("输入5 查看各个科目考试最高分");
        System.out.println("输入6 查看各个科目考试最低分");
        System.out.println("输入7 查看拿证的学生");
        System.out.println("输入q 退出");

    }
}
