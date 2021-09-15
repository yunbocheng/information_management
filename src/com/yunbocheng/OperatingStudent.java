package com.yunbocheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 定义一个操作学生的类
public class OperatingStudent {
    private Scanner scanner = new Scanner(System.in);
    // 定义一个学生的作为成员变量
    private Student student;
    // 定义一个存储学生信息的集合
    List<Student> list = new ArrayList<>();
    // 定义一个查询时这个学生是否存在的变量(0代表不存在，1代表存在)
    private Boolean judge = false;
    // 定义一个学生累加器
    private int sum = 1;

    // 学号具有唯一性
    private int studentID = 201801;

    // 添加一个学年
    private String schoolYear = null;
    // 添加一个学期
    private String semester = null;

    // 定义一个获取查询时的学号
    private int obtain = 0;



    // 定义一个获取用户操作方法的变量
    private int number = 0;

    public OperatingStudent() {
        print();
        choose();
    }

    // 定义一个功能选择区
    public void print(){
        System.out.println("***************学生信息管理系统***************");
        System.out.println("\t1.添加学生信息(姓名、班级、性别、籍贯)");
        System.out.println("\t2.录入学生成绩");
        System.out.println("\t3.查询学生个人信息");
        System.out.println("\t4.查询学生成绩");
        System.out.println("\t5.修改个人信息");
        System.out.println("\t6.删除学生信息");
        System.out.println("\t7.退出程序");
        System.out.println("***************版本号:1.0*********************\n");
    }
    // 定义一个选择的方法(使用分支结构)
    public void choose(){
        while (true){
            System.out.print("请输入您要操作的序号：");
            number = scanner.nextInt();
            switch (number){
                case 1 : add();break;
                case 2 : addScore();break;
                case 3 : personalInformation();break;
                case 4 : inquiry();break;
                case 5 : modifyInformation();break;
                case 6 : delete();break;
                case 7 :{
                    System.out.println("退出成功，欢迎再次使用");
                    System.exit(1);
                }
            }
            print();
        }
    }
    // 使用循环来存储学生信息直到输入 exit 停止
    public void add(){
        String name = null;
        String room = null;
        String sex = null;
        String residence = null;
        // 定义一个是否在继续添加学生信息的变量
        String decide = null;
        while (true){
            System.out.print("请输入第" + sum + "个学生的姓名：");
            name = scanner.next();
            System.out.print("请输入第"+sum + "个学生的班级：");
            room = scanner.next();
            System.out.print("请输入第"+sum + "个学生的性别：");
            sex = scanner.next();
            System.out.print("请输入第"+sum + "个学生的籍贯：");
            residence = scanner.next();
            student = new Student(name,room,sex,residence);
            list.add(student);
            System.out.print("是否继续添加学生(y/n)");
            decide = scanner.next();
            if (decide.equals("y")){
                sum += 1;
            }else {
                break;
            }
        }
        addStudentID();
    }

    // 给学生分配学号，并且这个学号具有唯一性，便于后期使用这个来查询学生对象
    public void addStudentID(){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setStudentID((studentID+i));
        }
    }

    // 给学生添加各科学分
    public void addScore() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("**************录入学生成绩**************");
            System.out.print("请录入第" + (i+1) + "个学生的Java成绩：");
            list.get(i).setJavaScore(scanner.nextDouble());
            System.out.print("请录入第" + (i+1) + "个学生的MySqL成绩：");
            list.get(i).setMysqlScore(scanner.nextDouble());
            System.out.print("请录入第" + (i+1) + "个学生的C成绩：");
            list.get(i).setcScore(scanner.nextDouble());
            if (i==list.size()-1){
                System.out.println();
            }
        }
    }
    // 定义一个打印学生个人信息的方法
    public void personalInformation(){
        System.out.println("==============================学生个人信息==============================");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("==============================END==============================");
        System.out.println();
    }

    // 定义一个查询学生成绩的方法 通过学号进行查询
    public void inquiry(){
        System.out.print("请输入查询成绩学生的学号：");
        obtain = scanner.nextInt();
        for (Student student : list) {
            if (student.getStudentID() == obtain){
                double overallResult = student.getMysqlScore()+student.getJavaScore()+student.getcScore();
                System.out.println("该学生的Java成绩为：" + student.getJavaScore());
                System.out.println("该学生的MySQL成绩为：" + student.getMysqlScore());
                System.out.println("该学生的C成绩为：" + student.getcScore());
                System.out.println("该学生的总成绩为：" + overallResult);
                System.out.println("该学生的平均成绩为：" + overallResult/3);
            }
        }
    }

    // 修改学生个人信息
    public void modifyInformation(){
        int demand = 0;
        System.out.print("请输入您要修改的学生信息对应的学号：");
        obtain = scanner.nextInt();
        Loop : while (true){
            modify();
            demand = scanner.nextInt();
            for (Student student : list) {
                if (student.getStudentID() == obtain){
                    switch (demand){
                        case 1 : {
                            System.out.print("请输入要修改的姓名：");
                            student.setName(scanner.next());
                            System.out.println("\t修改成功");
                        }break;
                        case 2 : {
                            System.out.print("请输入要修改的班级：");
                            student.setRoom(scanner.next());
                            System.out.println("\t修改成功");
                        }break;
                        case 3 : {
                            System.out.print("请输入要修改的性别：");
                            student.setSex(scanner.next());
                            System.out.println("\t修改成功");
                        }break;
                        case 4 : {
                            System.out.print("请输入要修改的籍贯：");
                            student.setResidence(scanner.next());
                            System.out.println("\t修改成功");
                        }break;
                        case 5 : {
                            System.out.print("请修改该学生的Java成绩：");
                            student.setJavaScore(scanner.nextDouble());
                            System.out.print("请修改该学生的MySqL成绩：");
                            student.setMysqlScore(scanner.nextDouble());
                            System.out.print("请修改该学生的C成绩：");
                            student.setcScore(scanner.nextDouble());
                            System.out.println("\t修改成功");
                        }break;
                        case 6 :{
                            System.out.println("\t退出成功");
                            break Loop;
                        }
                    }
                }
            }
        }
    }
    // 修改学生信息主界面
    public void  modify(){
        System.out.println("***************学生信息修改系统***************");
        System.out.println("\t1.修改学生姓名");
        System.out.println("\t2.修改学生班级");
        System.out.println("\t3.修改学生性别");
        System.out.println("\t4.修改学生籍贯");
        System.out.println("\t5.修改学生成绩");
        System.out.println("\t6.退出修改");
        System.out.println("***************版本号:1.0*********************\n");
        System.out.print("请选择您要修改的信息选项：");
    }

    // 删除学生信息
    public void delete(){
        System.out.print("请输入你要删除学生的学生学号：");
        obtain = scanner.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentID()== obtain){
                list.remove(i);
            }
        }
        System.out.println("\t删除成功");
    }
}
