package service;

import book.Book;
import utile.Tool;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService {

    /**
     *
     * 查询所有书籍信息
     *
     */
    public static void showBook(){
        //读取文件
        ArrayList<String> strings = Tool.readFile("book.txt");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     *
     * 添加书籍信息
     *
     */
    public static void addBook(){
        Book book = new Book();
        book.setId(Tool.getID());
        Scanner s=new Scanner(System.in);
        System.out.println("请输入书名:");
        book.setName(s.nextLine());
        System.out.println("请输入作者:");
        book.setAuthor(s.nextLine());
        System.out.println("请输入书本类型:");
        book.setType(s.nextLine());
        System.out.println("请输入书本价格:");
        book.setPrice(Double.valueOf(s.nextLine()));
        System.out.println("请输入书本数量:");
        book.setNumber(Integer.valueOf(s.nextLine()));
        Tool.writeFile(book.toString(),"book.txt");
    }



    /**
     *
     * 删除书籍
     *
     */
    public static void deleteBook(){
        ArrayList<String> strings = Tool.readFile("book.txt");
        System.out.println("请输入id进行删除:");
        Scanner s=new Scanner(System.in);
        Integer id = Integer.valueOf(s.nextLine());
        //通过id查找并删除
        strings.removeIf(string -> string.substring(string.indexOf("id=") + 3, string.indexOf(",")).equals(id + ""));
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        Tool.coverWriteFile(str,"book.txt");
    }


    /**
     *
     * 修改书籍信息
     *
     */
    public static void updateBook(){
        ArrayList<String> strings = Tool.readFile("book.txt");
        String replace ="";
        System.out.println("请输入id进行修改:");
        Scanner s=new Scanner(System.in);
        Integer id = Integer.valueOf(s.nextLine());
        for(int index=strings.size()-1;index>=0; index--){
            String string = strings.get(index);
            //通过id查找
            if (string.substring(string.indexOf("id=") + 3, string.indexOf(",")).equals(id + "")) {
                System.out.println("请选择修改项：");
                System.out.println("1.书名");
                System.out.println("2.作者");
                System.out.println("3.价格");
                System.out.println("4.类型");
                System.out.println("5.数量");
                int i = Integer.parseInt(s.nextLine());
                //输入选择
                switch (i) {
                    case 1:
                        System.out.println("输入新书名：");
                        String name = s.nextLine();
                        //通过string的substring取得name值
                        String substring = string.substring(string.indexOf("name=") + 5, string.indexOf(",", string.indexOf("name=")));

                        //通过string的replace将值替换
                        replace = string.replace(substring, name);
                        //删掉旧数据
                        strings.remove(string);
                        //添加新数据
                        strings.add(replace);
                        break;
                    case 2:
                        System.out.println("输入新作者：");
                        String author = s.nextLine();
                        substring = string.substring(string.indexOf("author=") + 7, string.indexOf(",", string.indexOf("author=")));
                        replace = string.replace(substring, author);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    case 3:
                        System.out.println("输入新价格：");
                        String price = s.nextLine();
                        substring = string.substring(string.indexOf("price=") + 6, string.indexOf(",", string.indexOf("price=")));
                        replace = string.replace(substring, price);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    case 4:
                        System.out.println("输入新类型：");
                        String type = s.nextLine();
                        substring = string.substring(string.indexOf("type=") + 5, string.indexOf(",", string.indexOf("type=")));
                        replace = string.replace(substring, type);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    case 5:
                        System.out.println("输入数量：");
                        String number = s.nextLine();
                        substring = string.substring(string.indexOf("number=") + 7);
                        replace = string.replace("number="+substring, "number="+number);
                        strings.remove(string);
                        strings.add(replace);
                        break;
                    default:
                        System.out.println("输入不正确请重新输入!!");
                }
            }
        }
        //将所有数据整理为一个String变量
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }

        //写入文件
        Tool.coverWriteFile(str,"book.txt");
    }

    /**
     *
     * 通过书名查询
     *
     */
    public static void getBookByName(){
        ArrayList<String> strings = Tool.readFile("book.txt");
        System.out.println("请输入查找书名:");
        Scanner s=new Scanner(System.in);
        String name = s.nextLine();
        boolean con = true;
        for (String string : strings) {
            String substring = string.substring(string.indexOf("name=") + 5, string.indexOf(",", string.indexOf("name=")));
            int i = substring.indexOf(name);
            if(i!=-1){
                con=false;
                System.out.println(string);
            }
        }

        if (con){
            System.out.println("并没有查找到这本书");
        }
    }
}
