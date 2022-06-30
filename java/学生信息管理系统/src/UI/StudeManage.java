package UI;

import BLL.*;
import DAL.Tool;
import Entity.Course;
import Entity.Manager;
import Entity.Student;
import Entity.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class StudeManage {

    public static void main(String[] args) {
        int i;
        Scanner s=new Scanner(System.in);
        Manager manager = null;
        Teacher teacher = null;
        Student student = null;
        do {
            indexMenu();
            i = Integer.parseInt(s.nextLine());
            switch (i) {
                case 1:
                    System.out.println("输入用户名：");
                    String name = s.nextLine();
                    System.out.println("输入密码：");
                    String password = s.nextLine();
                    manager = ManagerServer.login("select * from Manager where password='" + password + "' AND name='" + name + "';");
                    System.out.println(manager==null?"登录失败":"登录成功");
                    break;
                case 2:
                    System.out.println("输入用户名：");
                    name = s.nextLine();
                    System.out.println("输入密码：");
                    password = s.nextLine();
                    teacher = TeacherServer.login("select * from Teacher where password='" + password + "' AND name='" + name + "';");
                    System.out.println(teacher==null?"登录失败":"登录成功");
                    break;
                case 3:
                    System.out.println("输入用户名：");
                    name = s.nextLine();
                    System.out.println("输入密码：");
                    password = s.nextLine();
                    student = StudentServer.login("select * from student where password='" + password + "' AND name='" + name + "';");
                    System.out.println(student==null?"登录失败":"登录成功");
                    break;
                case 4:
                    System.out.println("感谢使用");
                    return;
                default:
                    System.out.println("输入不正确请重新输入!!");
            }
            // 判断是否登录
        }while (manager == null && teacher == null && student == null );


        if (manager!= null){
            do {
                menu();
                i = Integer.parseInt(s.nextLine());
                switch (i) {
                    case 1:
                        teacherManageMenu();
                        int j = Integer.parseInt(s.nextLine());
                        switch (j) {
                            case 1:
                                teacher = new Teacher();
                                System.out.println("输入教师姓名:");
                                teacher.setName(s.nextLine());
                                System.out.println("输入密码:");
                                teacher.setPassword(s.nextLine());
                                System.out.println("输入性别:");
                                teacher.setSex(s.nextLine());
                                System.out.println("输入教师出生年月(YYYY-MM-DD):");
                                teacher.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                System.out.println("输入所在学院:");
                                teacher.setCollege(s.nextLine());
                                System.out.println("输入主讲课程:");
                                teacher.setCourse(s.nextLine());
                                System.out.println("输入邮箱:");
                                teacher.setEmail(s.nextLine());
                                Integer insert = TeacherServer.insert(teacher);
                                System.out.println(teacher);
                                System.out.println("新建的教师Id为" + insert);
                                break;
                            case 2:
                                TeacherServer.List();
                                break;
                            case 3:
                                System.out.println("输入要查询的ID:");
                                TeacherServer.get(Integer.valueOf(s.nextLine()));
                                break;
                            case 4:
                                System.out.println("输入要修改的教师ID:");
                                teacher = TeacherServer.get(Integer.valueOf(s.nextLine()));
                                if (teacher!= null){
                                    System.out.println("输入要修改属性:");
                                    System.out.println("1.姓名:");
                                    System.out.println("2.密码:");
                                    System.out.println("3.性别:");
                                    System.out.println("4.出生年月:");
                                    System.out.println("5.所在学院:");
                                    System.out.println("6.主讲课程:");
                                    System.out.println("7.邮箱:");
                                    int k = Integer.parseInt(s.nextLine());
                                    switch (k) {
                                        case 1:
                                            System.out.println("输入新名字:");
                                            teacher.setName(s.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("输入新密码:");
                                            teacher.setPassword(s.nextLine());
                                            break;
                                        case 3:
                                            System.out.println("输入新性别:");
                                            teacher.setSex(s.nextLine());
                                            break;
                                        case 4:
                                            System.out.println("输入新出生年月:");
                                            teacher.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                            break;
                                        case 5:
                                            System.out.println("输入所在学校:");
                                            teacher.setCollege(s.nextLine());
                                            break;
                                        case 6:
                                            System.out.println("输入主讲课程:");
                                            teacher.setCourse(s.nextLine());
                                            break;
                                        case 7:
                                            System.out.println("输入新邮箱:");
                                            teacher.setEmail(s.nextLine());
                                            break;
                                        default:
                                            System.out.println("输入不正确请重新输入!!");
                                    }
                                    TeacherServer.update(teacher);
                                    System.out.println(teacher);
                                }
                                break;
                            case 5:
                                System.out.println("输入要删除的教师的ID:");
                                TeacherServer.delete(Integer.valueOf(s.nextLine()));
                                break;
                            default:
                                System.out.println("输入不正确请重新输入!!");
                        }
                        break;
                    case 2:
                        studentManageMenu();
                        j = Integer.parseInt(s.nextLine());
                        switch (j) {
                            case 1:
                                student = new Student();
                                System.out.println("输入学生姓名:");
                                student.setName(s.nextLine());
                                System.out.println("输入密码:");
                                student.setPassword(s.nextLine());
                                System.out.println("输入性别:");
                                student.setSex(s.nextLine());
                                System.out.println("输入出生年月(YYYY-MM-DD):");
                                student.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                System.out.println("输入所在学院:");
                                student.setCollege(s.nextLine());
                                System.out.println("输入所学专业:");
                                student.setMajor(s.nextLine());
                                System.out.println("输入所在班级:");
                                student.setStuClass(s.nextLine());
                                Integer insert = StudentServer.insert(student);
                                System.out.println(student);
                                System.out.println("新建的学生Id为" + insert);
                                break;
                            case 2:
                                StudentServer.List();
                                break;
                            case 3:
                                System.out.println("输入要查询学生的ID:");
                                StudentServer.getByID(Integer.valueOf(s.nextLine()));
                                break;
                            case 4:
                                System.out.println("输入要查询学生的班级:");
                                StudentServer.getByClass(s.nextLine());
                                break;
                            case 5:
                                System.out.println("输入要修改的学生ID:");
                                student = StudentServer.getByID(Integer.valueOf(s.nextLine()));
                                if (student!= null){
                                    System.out.println("输入要修改属性:");
                                    System.out.println("1.姓名:");
                                    System.out.println("2.密码:");
                                    System.out.println("3.性别:");
                                    System.out.println("4.出生年月:");
                                    System.out.println("5.所在学院:");
                                    System.out.println("6.所学专业:");
                                    System.out.println("7.所在班级:");
                                    int k = Integer.parseInt(s.nextLine());
                                    switch (k) {
                                        case 1:
                                            System.out.println("输入新名字:");
                                            student.setName(s.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("输入新密码:");
                                            student.setPassword(s.nextLine());
                                            break;
                                        case 3:
                                            System.out.println("输入新性别:");
                                            student.setSex(s.nextLine());
                                            break;
                                        case 4:
                                            System.out.println("输入新出生年月:");
                                            student.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                            break;
                                        case 5:
                                            System.out.println("输入所在学校:");
                                            student.setCollege(s.nextLine());
                                            break;
                                        case 6:
                                            System.out.println("输入所学专业:");
                                            student.setMajor(s.nextLine());
                                            break;
                                        case 7:
                                            System.out.println("输入所在班级:");
                                            student.setStuClass(s.nextLine());
                                            break;
                                        default:
                                            System.out.println("输入不正确请重新输入!!");
                                    }
                                    StudentServer.update(student);
                                    System.out.println(student);
                                }
                                break;
                            case 6:
                                System.out.println("输入要删除的学生的ID:");
                                StudentServer.delete(Integer.valueOf(s.nextLine()));
                                break;
                            default:
                                System.out.println("输入不正确请重新输入!!");
                        }
                        break;
                    case 3:
                        courseManageMenu();
                        j = Integer.parseInt(s.nextLine());
                        switch (j) {
                            case 1:
                                Course course = new Course();
                                System.out.println("输入课程名:");
                                course.setCname(s.nextLine());
                                System.out.println("输入教师id:");
                                course.setTid(Integer.valueOf(s.nextLine()));
                                System.out.println("输入上课班级:");
                                course.setStuClass(s.nextLine());
                                CourseServer.insert(course);
                                System.out.println(course);
                                break;
                            case 2:
                                CourseServer.List();
                                break;
                            case 3:
                                System.out.println("输入要查询的课程的ID:");
                                CourseServer.getByID(Integer.valueOf(s.nextLine()));
                                break;
                            case 4:
                                System.out.println("输入要查询的课程的课程名:");
                                CourseServer.getByName(s.nextLine());
                                break;
                            case 5:
                                System.out.println("输入要查询的课程的教师id:");
                                CourseServer.getByTid(Integer.valueOf(s.nextLine()));
                                break;
                            case 6:
                                System.out.println("输入要查询的课程的班级:");
                                CourseServer.getByClass(s.nextLine());
                                break;
                            case 7:
                                System.out.println("输入要修改的课程ID:");
                                course = CourseServer.getByID(Integer.valueOf(s.nextLine()));
                                if (course!= null){
                                    System.out.println("输入要修改属性:");
                                    System.out.println("1.课程名:");
                                    System.out.println("2.教师id:");
                                    System.out.println("3.班级名:");
                                    int k = Integer.parseInt(s.nextLine());
                                    switch (k) {
                                        case 1:
                                            System.out.println("输入新课程名:");
                                            course.setCname(s.nextLine());
                                            break;
                                        case 2:
                                            System.out.println("输入新教师id:");
                                            course.setTid(Integer.valueOf(s.nextLine()));
                                            break;
                                        case 3:
                                            System.out.println("输入新班级名:");
                                            course.setStuClass(s.nextLine());
                                            break;
                                        default:
                                            System.out.println("输入不正确请重新输入!!");
                                    }
                                    CourseServer.update(course);
                                    System.out.println(course);
                                }
                                break;
                            case 8:
                                System.out.println("输入要删除的课程的ID:");
                                CourseServer.delete(Integer.valueOf(s.nextLine()));
                                break;
                            default:
                                System.out.println("输入不正确请重新输入!!");
                        }
                        break;
                    case 4:
                        System.out.println(manager);
                        System.out.println("输入要修改属性:");
                        System.out.println("1.密码:");
                        System.out.println("2.用户名:");
                        System.out.println("3.性别:");
                        System.out.println("4.出生年月:");
                        int k = Integer.parseInt(s.nextLine());
                        switch (k) {
                            case 1:
                                System.out.println("输入新密码:");
                                manager.setPassword(s.nextLine());
                                break;
                            case 2:
                                System.out.println("输入新用户名:");
                                manager.setName(s.nextLine());
                                break;
                            case 3:
                                System.out.println("输入新性别:");
                                manager.setSex(s.nextLine());
                                break;
                            case 4:
                                System.out.println("输入新出生年月:");
                                manager.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                break;
                            default:
                                System.out.println("输入不正确请重新输入!!");
                        }
                        ManagerServer.update(manager);
                        System.out.println(manager);
                        break;
                    case 5:
                        System.out.println("感谢使用");
                        break;
                    default:
                        System.out.println("输入不正确请重新输入!!");
                }

            }while (i != 5);
        }

        if (teacher!= null){
            do {
                teacherMenu();
                i = Integer.parseInt(s.nextLine());
                switch (i) {
                    case 1:
                        System.out.println("输入课程id:");
                        CourseServer.ListSid(Integer.valueOf(s.nextLine()));
                        break;
                    case 2:
                        ScoreServer.getByTid(teacher.getTid());
                        break;
                    case 3:
                        System.out.println("输入课程id:");
                        ScoreServer.List(Integer.valueOf(s.nextLine()));
                        break;
                    case 4:
                        System.out.println(teacher);
                        System.out.println("输入要修改属性:");
                        System.out.println("1.密码:");
                        System.out.println("2.用户名:");
                        System.out.println("3.性别:");
                        System.out.println("4.出生年月:");
                        System.out.println("5.所在学校:");
                        System.out.println("6.主讲课程:");
                        System.out.println("7.邮箱:");
                        int k = Integer.parseInt(s.nextLine());
                        switch (k) {
                            case 1:
                                System.out.println("输入新密码:");
                                teacher.setPassword(s.nextLine());
                                break;
                            case 2:
                                System.out.println("输入新用户名:");
                                teacher.setName(s.nextLine());
                                break;
                            case 3:
                                System.out.println("输入新性别:");
                                teacher.setSex(s.nextLine());
                                break;
                            case 4:
                                System.out.println("输入新出生年月:");
                                teacher.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                break;
                            case 5:
                                System.out.println("输入所在学校:");
                                teacher.setCollege(s.nextLine());
                                break;
                            case 6:
                                System.out.println("输入主讲课程:");
                                teacher.setCourse(s.nextLine());
                                break;
                            case 7:
                                System.out.println("输入新邮箱:");
                                teacher.setEmail(s.nextLine());
                                break;
                            default:
                                System.out.println("输入不正确请重新输入!!");
                        }
                        TeacherServer.update(teacher);
                        System.out.println(teacher);
                        break;
                    case 5:
                        System.out.println("感谢使用");
                        break;

                    default:
                        System.out.println("输入不正确请重新输入!!");

                }
            }while (i!=5);
        }

        if (student!= null) {
            do {
                studentMenu();
                i = Integer.parseInt(s.nextLine());
                switch (i) {
                    case 1:
                        ScoreServer.ListStudent(student.getSid());
                        break;
                    case 2:
                        System.out.println(student);
                        System.out.println("输入要修改属性:");
                        System.out.println("1.密码:");
                        System.out.println("2.姓名:");
                        System.out.println("3.性别:");
                        System.out.println("4.出生年月:");
                        System.out.println("5.所在学校:");
                        System.out.println("6.专业:");
                        System.out.println("7.班级:");
                        int k = Integer.parseInt(s.nextLine());
                        switch (k) {
                            case 1:
                                System.out.println("输入新密码:");
                                student.setPassword(s.nextLine());
                                break;
                            case 2:
                                System.out.println("输入新用户名:");
                                student.setName(s.nextLine());
                                break;
                            case 3:
                                System.out.println("输入新性别:");
                                student.setSex(s.nextLine());
                                break;
                            case 4:
                                System.out.println("输入新出生年月:");
                                student.setDateOfBirth(LocalDate.parse(s.nextLine()));
                                break;
                            case 5:
                                System.out.println("输入所在学校:");
                                student.setCollege(s.nextLine());
                                break;
                            case 6:
                                System.out.println("输入专业:");
                                student.setMajor(s.nextLine());
                                break;
                            case 7:
                                System.out.println("输入班级:");
                                student.setStuClass(s.nextLine());
                                break;
                            default:
                                System.out.println("输入不正确请重新输入!!");
                        }
                        StudentServer.update(student);
                        System.out.println(student);
                        break;
                    case 3:
                        ScoreServer.printStudentScore(student.getSid());
                        break;
                    case 4:
                        System.out.println("感谢使用");
                        break;

                }
            }while (i!=4);
        }

    }

    /**
     *
     * 菜单
     *
     */
    public static void menu(){

        System.out.println("--------------------浙江树人大学学生成绩管理系统--------------------");
        System.out.println("------------1.教师管理");
        System.out.println("------------2.学生管理");
        System.out.println("------------3.课程管理");
        System.out.println("------------4.信息维护");
        System.out.println("------------5.退出系统");
    }
    public static void teacherManageMenu(){

        System.out.println("--------------------教师管理--------------------");
        System.out.println("------------1.添加教师信息");
        System.out.println("------------2.查询所有教师信息");
        System.out.println("------------3.通过id查询教师信息");
        System.out.println("------------4.修改教师信息");
        System.out.println("------------5.删除教师信息");
    }
    public static void studentManageMenu(){

        System.out.println("--------------------学生管理--------------------");
        System.out.println("------------1.添加学生信息");
        System.out.println("------------2.查询所有学生信息");
        System.out.println("------------3.通过id查询学生信息");
        System.out.println("------------4.通过班级查询学生信息");
        System.out.println("------------5.修改学生信息");
        System.out.println("------------6.删除学生信息");
    }
    public static void courseManageMenu(){

        System.out.println("--------------------课程管理--------------------");
        System.out.println("------------1.添加课程信息");
        System.out.println("------------2.查询所有课程信息");
        System.out.println("------------3.通过id查询课程信息");
        System.out.println("------------4.通过课程名查询课程信息");
        System.out.println("------------5.通过教师id查询课程信息");
        System.out.println("------------6.通过班级查询课程信息");
        System.out.println("------------7.修改课程信息");
        System.out.println("------------8.删除课程信息");
    }
    public static void teacherMenu(){

        System.out.println("--------------------浙江树人大学学生成绩管理系统--------------------");
        System.out.println("------------1.录入成绩");
        System.out.println("------------2.统计成绩");
        System.out.println("------------3.查看成绩");
        System.out.println("------------4.信息维护");
        System.out.println("------------5.退出系统");
    }
    public static void studentMenu(){

        System.out.println("--------------------浙江树人大学学生成绩管理系统--------------------");
        System.out.println("------------1.查看成绩单");
        System.out.println("------------2.信息维护");
        System.out.println("------------3.打印成绩单");
        System.out.println("------------4.退出系统");
    }
    public static void indexMenu(){
        System.out.println("--------------------浙江树人大学学生成绩管理系统--------------------");
        System.out.println("------------1.管理员登录");
        System.out.println("------------2.教师登录");
        System.out.println("------------3.学生登录");
        System.out.println("------------4.退出系统");
    }



}
