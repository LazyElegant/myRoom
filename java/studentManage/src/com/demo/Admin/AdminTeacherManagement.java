package com.demo.Admin;

import java.util.Scanner;

public class AdminTeacherManagement {

    public static void App() {
        System.out.println("添加教师请输入1");
        System.out.println("删除教师请输入2");
        System.out.println("教师信息修改请输入3");
        System.out.println("查看教师请输入4");
        System.out.println("禁用教师账号请输入5");
        System.out.println("重置密码请输入6");
        System.out.println("返回上一级请输入quit");
        System.out.println("退出系统输入exit");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        if(userInput.equals("1")) {
            AdminAddTeacher.App();
        } else if(userInput.equals("2")) {
            AdminDeleteTeacher.App();
        } else if(userInput.equals("3")) {
            AdminUpdateTeacher.App();
        } else if(userInput.equals("4")) {
            AdminTeacherList.App();
        } else if(userInput.equals("5")) {
            AdminBanTeacher.App();
        } else if(userInput.equals("6")) {
            AdminUpdatePasswordTeacher.App();
        } else if(userInput.equals("quit")) {
            AdminIndex.App();
        } else {
            System.err.println("您输入有误，请按照提示进行输入！");
            AdminTeacherManagement.App();
        }
    }

}
