
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @Author admin
 * @create 2022/5/27 22:49
 */
public class PersonalManage {

    public static void main(String[] args) {
        int i;
        do {
           menu();
           Scanner s=new Scanner(System.in);
           i = s.nextInt();
           switch (i) {
               case 1:
                   showPersonal();
                   break;
               case 2:
                   addPersonal();
                   break;
               case 3:
                   deletePersonal();
                   break;
               case 4:
                   updatePersonal();
                   break;
               case 5:
                   getPersonalByName();
                   break;
               case 6:
                   getPersonalByAddress();
                   break;
               case 7:
                   System.out.println("感谢使用");
                   break;
               default:
                   System.out.println("输入不正确请重新输入!!");
           }

       }while (i != 7);

    }

    /**
     *
     * 菜单
     *
     */
    public static void menu(){

        System.out.println("---------------------------个人信息管理系统---------------------------");
        System.out.println("------------1.查询所有人信息");
        System.out.println("------------2.添加个人信息");
        System.out.println("------------3.删除个人信息");
        System.out.println("------------4.修改个人信息");
        System.out.println("------------5.通过名字查询个人信息");
        System.out.println("------------6.通过地址查询个人信息");
        System.out.println("------------7.退出");
    }

    /**
     *
     * 查询所有人信息
     *
     */
    public static void showPersonal(){
        //读取文件
        ArrayList<String> strings = Tool.readFile();
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     *
     * 添加个人信息
     *
     */
    public static void addPersonal(){
        Personal personal = new Personal();
        personal.setId(Tool.getID());
        Scanner s=new Scanner(System.in);
        System.out.println("请输入姓名:");
        personal.setName(s.nextLine());
        System.out.println("请输入地址:");
        personal.setAddress(s.nextLine());
        System.out.println("请输入电话号码:");
        personal.setNumber(Long.valueOf(s.nextLine()));
        System.out.println("请输入邮箱:");
        personal.setEmail(s.nextLine());
        Tool.writeFile(personal.toString());
    }

    /**
     *
     * 删除个人信息
     *
     */
    public static void deletePersonal(){
        ArrayList<String> strings = Tool.readFile();
        System.out.println("请输入id进行删除:");
        Scanner s=new Scanner(System.in);
        Integer id =s.nextInt();
        //通过id查找并删除
        strings.removeIf(string -> string.substring(string.indexOf("=") + 1, string.indexOf(",")).equals(id + ""));
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        Tool.coverWriteFile(str);
    }

    /**
     *
     * 修改个人信息
     *
     */
    public static void updatePersonal(){
        ArrayList<String> strings = Tool.readFile();
        String replace ="";
        System.out.println("请输入id进行修改:");
        Scanner s=new Scanner(System.in);
        Integer id = Integer.valueOf(s.nextLine());
        for(int index=strings.size()-1;index>=0; index--){
            String string = strings.get(index);
            //通过id查找
            if (string.substring(string.indexOf("=") + 1, string.indexOf(",")).equals(id + "")) {
                System.out.println("请选择修改项：");
                System.out.println("1.姓名");
                System.out.println("2.电话号码");
                System.out.println("3.地址");
                System.out.println("4.邮箱");
                int i = Integer.parseInt(s.nextLine());
                //输入选择
                switch (i) {
                    case 1:
                        System.out.println("输入新姓名：");
                        String name = s.nextLine();
                        String substring = string.substring(string.indexOf("=", string.indexOf("=") + 1) + 1, string.indexOf(",", string.indexOf(",") + 1));
                        replace = string.replace(substring, name);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    case 2:
                        System.out.println("输入新电话号码：");
                        String number = s.nextLine();
                        int fromIndex = string.indexOf("=", string.indexOf("=") + 1) + 1;
                        int dIndex = string.indexOf(",", string.indexOf(",") + 1) + 1;
                        substring = string.substring(string.indexOf("=", fromIndex) + 1, string.indexOf(",", dIndex) );
                        replace = string.replace(substring, number);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    case 3:
                        System.out.println("输入新地址：");
                        String address = s.nextLine();
                        fromIndex = string.indexOf("=", string.indexOf("=",string.indexOf("=")+1) + 1) + 1;
                        dIndex = string.indexOf(",", string.indexOf(",",string.indexOf(",")+1) + 1) + 1;
                        substring = string.substring(string.indexOf("=", fromIndex) + 1, string.indexOf(",", dIndex) );
                        replace = string.replace(substring, address);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    case 4:
                        System.out.println("输入新邮箱：");
                        String email = s.nextLine();
                        fromIndex = string.indexOf("=", string.indexOf("=",string.indexOf("=",string.indexOf("=")+1)+1) + 1) + 1;
                        substring = string.substring(string.indexOf("=", fromIndex) + 1);
                        replace = string.replace(substring, email);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    default:
                        System.out.println("输入不正确请重新输入!!");
                }
            }
        }
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        Tool.coverWriteFile(str);
    }

    /**
     *
     * 通过姓名查询
     *
     */
    public static void getPersonalByName(){
        ArrayList<String> strings = Tool.readFile();
        System.out.println("请输入查找姓名:");
        Scanner s=new Scanner(System.in);
        String name = s.nextLine();
        boolean con = true;
        for (String string : strings) {
            String substring = string.substring(string.indexOf("=", string.indexOf("=") + 1) + 1, string.indexOf(",", string.indexOf(",") + 1));
            int i = substring.indexOf(name);
            if(i!=-1){
                con=false;
                System.out.println(string);
            }
        }

        if (con){
            System.out.println("查无此人");
        }
    }

    /**
     *
     * 通过地址查询
     *
     */
    public static void getPersonalByAddress(){
        ArrayList<String> strings = Tool.readFile();
        System.out.println("请输入查找地址:");
        Scanner s=new Scanner(System.in);
        String address = s.nextLine();
        boolean con = true;
        for (String string : strings) {
            int fromIndex = string.indexOf("=", string.indexOf("=",string.indexOf("=")+1) + 1) + 1;
            int dIndex = string.indexOf(",", string.indexOf(",",string.indexOf(",")+1) + 1) + 1;
            String substring = string.substring(string.indexOf("=", fromIndex) + 1, string.indexOf(",", dIndex) );
            int i = substring.indexOf(address);
            if(i!=-1){
                con=false;
                System.out.println(string);
            }
        }

        if (con){
            System.out.println("查无此人");
        }
    }

}
