package com.yunbocheng;

import java.util.Random;
import java.util.Scanner;

public class ManagerLogin {

    public ManagerLogin() {
        select();
    }
    private  Scanner scanner = new Scanner(System.in);
    // 定义几个已经存在的管理员信息(因为没有数据库)
    Manager manager1 = new Manager("13131484379","1234CYBcyb.");
    Manager manager2 = new Manager("18131482447","5678CYBcyb.");

    // 新注册的管理员
    Manager manager = null;
    // 密码长度8-20位且至少包含大写字母、小写字母、数字或特殊符号中的任意三种
    public static final String regex = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)(?![a-z\\W_]+$)(?![0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,20}$";
    // 写一个登录系统的界面(进行选择已有账号还是注册账号)
    public void select(){
        mainPage();
        System.out.print("请选择登录选项：");
        int number = scanner.nextInt();
        switch (number){
            case 1 : exist();break;
            case 2 : {
                registered();
                System.out.println("请登录刚注册的管理员账号密码");
                logIn();
                break;
            }
        }
    }
    // 定义一个打印主页面的方法
    public void mainPage(){
        System.out.println("欢迎使用学生信息管理系统");
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("\t1.已有账号");
        System.out.println("\t2.注册账号");
        for (int i = 0; i < 20; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    // 定义一个登录已有账号界面的方法
    public  void exist(){
            while (true){
            String str = null;
            String code = null;
            System.out.print("请输入账号：");
            String account = scanner.next();
            System.out.print("请输入密码：");
            String password = scanner.next();
            str = getRandomString(4);
            System.out.println("验证码:" + str);
            System.out.print("请输入验证码(不区分大小写)：");
            code = new Scanner(System.in).next();
            if (account.equals(manager1.getAccount()) && password.equals(manager1.getPassword()) ||
                    account.equals(manager2.getAccount())&&password.equals(manager2.getPassword())){
                if (code.equalsIgnoreCase(str)){
                    System.out.println("登录成功");break;
                }else {
                    System.out.println("验证码不正确，请重新输入！");
                }
            }else {
                System.out.println("用户名或密码错误，请重新输入！");
            }
        }
    }

    // 随机生成一个4位验证码
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    // 定义一个注册新账号的方式
    public void registered(){
        while (true){
            System.out.print("请输入注册账号(必须是手机号)：");
            String account = scanner.next();
            System.out.print("请输入注册密码(必须包含大写字母、小写字母、数字、特殊字符中的任意三种)：");
            String password = scanner.next();
            System.out.print("请再次输入注册密码：");
            String newPassword = scanner.next();
            if (account.length()==11 && password.matches(regex) && !account.equals("13131484379") && !account.equals("18131482447") && password.equals(newPassword)){
                await();
                System.out.println("\t注册成功");
                manager = new Manager(account,password);
                break;
            }else if (account.length()!=11 && password.matches(regex) ) {
                await();
                System.out.println("输入的账号不符合要求，请重新注册");
            }else if (account.length() ==11 && !password.matches(regex)){
                await();
                System.out.println("输入的密码不符合要求，请重新注册");
            }else if (account.length()!= 11 && !password.matches(regex)){
                await();
                System.out.println("账号和密码都不符合要求，请重新注册");
            } else if(account.equals("13131484379") || account.equals("18131482447")){
                await();
                System.out.println("该账号已被注册，请重新注册");
            } else if (!newPassword.equals(password)){
                await();
                System.out.println("输入的两次密码不匹配，请重新注册");
            }
        }
    }
    // 定义登录管理员方法
    public void logIn(){
        while (true){
            String str = null;
            String code = null;
            System.out.print("请输入账号：");
            String account = scanner.next();
            System.out.print("请输入密码：");
            String password = scanner.next();
            str = getRandomString(4);
            System.out.println("验证码:" + str);
            System.out.print("请输入验证码(不区分大小写)：");
            code = new Scanner(System.in).next();
            if (account.equals(manager.getAccount()) && password.equals(manager.getPassword())){
                if (code.equalsIgnoreCase(str)){
                    System.out.println("\t登录成功");break;
                }else {
                    System.out.println("验证码不正确，请重新输入！");
                }
            }else {
                System.out.println("用户名或密码错误，请重新输入！");
            }
        }
    }
    // 定义一个等待注册的方法
    public void await(){
        System.out.println("正在注册中，请稍等...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
