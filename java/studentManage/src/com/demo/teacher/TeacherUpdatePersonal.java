package com.demo.teacher;

import com.demo.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherUpdatePersonal {
    public static void App() {
        System.out.println("请输入要修改的属性：");
        System.out.println("1.姓名");
        System.out.println("2.性别");
        System.out.println("3.电话号码");
        System.out.println("4.邮箱");
        System.out.println("5.年龄");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        switch (input){
            case 1:
                System.out.println("请输入新名字：");
                String name = NameVerify.App();
                i = Sql_Statement_Update.App("update teacher SET name ='"+name+"' WHERE code = '" +TeacherLogin.code + "'");
                break;
            case 2:
                System.out.println("请输入新性别：");
                String sex = StuGenderVerify.App();
                i = Sql_Statement_Update.App("update teacher SET sex ='"+sex+"' WHERE code = '" +TeacherLogin.code + "'");
                break;
            case 3:
                System.out.println("请输入新电话号码：");
                String stuTel = StuTelVerify.App();
                i = Sql_Statement_Update.App("update teacher SET tel ='"+stuTel+"' WHERE code = '" +TeacherLogin.code + "'");
                break;
            case 4:
                System.out.println("请输入新邮箱：");
                String stuEmail = StuEmailVerify.App();
                i = Sql_Statement_Update.App("update teacher SET email ='"+stuEmail+"' WHERE code = '" +TeacherLogin.code + "'");
                break;
            case 5:
                System.out.println("请输入新年龄：");
                int stuAge = Integer.parseInt(sc.nextLine());
                i = Sql_Statement_Update.App("update teacher SET age ="+stuAge+" WHERE code = '" +TeacherLogin.code + "'");
                break;
        }
        if (i>0) {
            System.out.println("修改成功!!!");
        }else {
            System.out.println("修改失败!!!");
        }
        TeacherPersonalManagement.App();
    }
}
