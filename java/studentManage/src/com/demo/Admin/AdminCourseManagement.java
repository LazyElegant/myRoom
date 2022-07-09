package com.demo.Admin;

import java.util.Scanner;

public class AdminCourseManagement {

    public static void App() {
        System.out.println("添加课程请输入1");
        System.out.println("删除课程请输入2");
        System.out.println("修改课程请输入3");
        System.out.println("查看课程请输入4");
        System.out.println("返回上一级请输入quit");
        System.out.println("退出系统输入exit");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        if(userInput.equals("1")) {
            AdminAddCourse.App();
        } else if(userInput.equals("2")) {
            AdminDeleteCourse.App();
        } else if(userInput.equals("3")) {
            AdminUpdateCourse.App();
        } else if(userInput.equals("4")) {
            AdminCourseList.App();
        } else if(userInput.equals("quit")) {
            AdminIndex.App();
        } else {
            System.err.println("您输入有误，请按照提示进行输入！");
            AdminCourseManagement.App();
        }
    }

}
