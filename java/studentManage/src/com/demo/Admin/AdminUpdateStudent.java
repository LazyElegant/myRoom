package com.demo.Admin;

import com.demo.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminUpdateStudent {
    public static void App() {
        try {
            ResultSet app = Sql_Statement_Query.App("SELECT s.id,s.code,s.name,s.sex,c.name,s.tel,s.email,s.age FROM student s Left Join class c on c.code = s.class_code where s.state = 1");
            while (app.next()) {
                System.out.println("学号: "+app.getString(2)+",姓名: "+app.getString(3)+",性别: "+app.getString(4)+",班级: "
                        +app.getString(5)+",电话号码: " +app.getString(6)+",邮箱: "+app.getString(7)+",年龄: "+app.getInt(8));
            }
            DbUtil.close(null,null,app,null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("请输入要修改的学生学号：");
        String code = CodeVerify.App();
        System.out.println("请输入要修改的属性：");
        System.out.println("1.姓名");
        System.out.println("2.性别");
        System.out.println("3.班级");
        System.out.println("4.电话号码");
        System.out.println("5.邮箱");
        System.out.println("6.年龄");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());

        switch (input){
            case 1:
                System.out.println("请输入新名字：");
                String name =NameVerify.App();
                i = Sql_Statement_Update.App("update student SET name ='"+name+"' WHERE code = '" +code + "'");
                break;
            case 2:
                System.out.println("请输入新性别：");
                String sex = StuGenderVerify.App();
                i = Sql_Statement_Update.App("update student SET sex ='"+sex+"' WHERE code = '" +code + "'");
                break;
            case 3:
                try {
                    ResultSet app = Sql_Statement_Query.App("SELECT * FROM class");
                    while (app.next()) {
                        System.out.println("班级编号: "+app.getString(2)+",班级名: "+app.getString(3));
                    }
                    DbUtil.close(null,null,app,null);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.out.println("输入班级编号选择新班级：");
                String classNumber = sc.nextLine();
                i = Sql_Statement_Update.App("update student SET class_code ='"+classNumber+"' WHERE code = '" +code + "'");
                break;
            case 4:
                System.out.println("请输入新电话号码：");
                String stuTel = StuTelVerify.App();
                i = Sql_Statement_Update.App("update student SET tel ='"+stuTel+"' WHERE code = '" +code + "'");
                break;
            case 5:
                System.out.println("请输入新邮箱：");
                String stuEmail = StuEmailVerify.App();
                i = Sql_Statement_Update.App("update student SET email ='"+stuEmail+"' WHERE code = '" +code + "'");
                break;
            case 6:
                System.out.println("请输入新年龄：");
                int stuAge = Integer.parseInt(sc.nextLine());
                i = Sql_Statement_Update.App("update student SET age ="+stuAge+" WHERE code = '" +code + "'");
                break;
        }
        if (i>0) {
            System.out.println("修改成功!!!");
        }else {
            System.out.println("修改失败!!!");
        }
        AdminStudentManagement.App();
    }
}