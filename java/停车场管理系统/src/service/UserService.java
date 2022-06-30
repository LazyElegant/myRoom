package service;

import user.User;

import utile.Tool;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UserService {


    /**
     *
     * 登录
     *
     */
    public static User login(){
        Scanner s=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = s.nextLine();
        System.out.println("请输入密码:");
        String password = s.nextLine();
        //从user.txt中读取用户信息
        LinkedList<String> strings = Tool.readFile("user.txt");
        for (String string : strings) {
            //用string的substring方法取出name和password
            String subName = string.substring(string.indexOf("name=") + 5, string.indexOf(",",string.indexOf("name=") ));
            String subPassword = string.substring(string.indexOf("password=") + 9, string.indexOf(",",string.indexOf("password=") ));
            //对比name和password都相等则登录成功
            if (subName.equals(name) && subPassword.equals(password)) {

                System.out.println("登录成功！！");
                String id = string.substring(string.indexOf("id=") + 3, string.indexOf(",",string.indexOf("id=") ));
                String status = string.substring(string.indexOf("status=") + 7);
                User user = new User();
                user.setId(Integer.valueOf(id));
                user.setPassword(password);
                user.setName(name);
                user.setStatus(Integer.valueOf(status));
                //将登录的user返回
                return user;
            }
        }
        System.out.println("登录失败！！");
        return null;
    }

    /**
     *
     * 注册
     *
     */
    public static void register(){
        User user = new User();
        user.setId(Tool.getID());
        Scanner s=new Scanner(System.in);
        System.out.println("请输入用户名:");
        user.setName(s.nextLine());
        System.out.println("请输入密码:");
        user.setPassword(s.nextLine());
        user.setStatus(2);
        //将输入的信息输出到user.txt中
        Tool.writeFile(user.toString(),"user.txt");
        System.out.println("注册成功!!");
    }

    /**
     *
     * 修改密码
     *
     */
    public static void updatePassword(User user){
        LinkedList<String> strings = Tool.readFile("user.txt");

        strings.remove(user.toString());
        Scanner s=new Scanner(System.in);


        System.out.println("请输入密码:");
        user.setPassword(s.nextLine());
        strings.add(user.toString());
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        //将输入的信息输出到user.txt中
        Tool.coverWriteFile(str,"user.txt");
        System.out.println("修改成功!!");
    }

    /**
     *
     * 重置密码
     *
     */
    public static void resetPassword(){
        LinkedList<String> strings = Tool.readFile("user.txt");

        Scanner s=new Scanner(System.in);
        System.out.println("请输入要重置的用户id:");
        String id = s.nextLine();
        for (String string : strings) {
            String substring = string.substring(string.indexOf("id=") + 3, string.indexOf(", name"));
            if (substring.equals(id)){
                System.out.println("请输入重置的密码:");
                String password = s.nextLine();
                substring = string.substring(string.indexOf("password=") + 9, string.indexOf(", status"));
                String replace = string.replace(substring, password);
                strings.remove(string);
                strings.add(replace);
                System.out.println("修改成功!!");
            }
        }

        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        //将输入的信息输出到user.txt中
        Tool.coverWriteFile(str,"user.txt");
    }
}
