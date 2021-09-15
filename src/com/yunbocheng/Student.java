package com.yunbocheng;

// 学生类 存储个人信息
public class Student {
    // 姓名
    private String name;
    // 班级
    private String room;
    // 学号（保证唯一性）
    private int studentID;
    // 性别
    private String sex;
    // 居住地
    private String Residence;
    // Java成绩
    private double javaScore;
    // MySQL成绩
    private double mysqlScore;
    // C成绩
    private double cScore;

    public Student() {

    }

    public Student(String name, String room, String sex, String residence) {
        this.name = name;
        this.room = room;
        this.sex = sex;
        Residence = residence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(double javaScore) {
        this.javaScore = javaScore;
    }

    public double getMysqlScore() {
        return mysqlScore;
    }

    public void setMysqlScore(double mysqlScore) {
        this.mysqlScore = mysqlScore;
    }

    public double getcScore() {
        return cScore;
    }

    public void setcScore(double cScore) {
        this.cScore = cScore;
    }

    public String getResidence() {
        return Residence;
    }

    public void setResidence(String residence) {
        Residence = residence;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\t性别：" + sex + "\t班级：" + room + "\t居住地：" +  Residence + "\t学号：" + studentID;
    }

}

