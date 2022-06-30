package service;

import book.Borrow;
import user.User;
import utile.Tool;

import java.util.ArrayList;
import java.util.Scanner;

public class BorrowService {


    /**
     *
     * 借阅
     *
     */
    public static void borrowBook(User user){
        ArrayList<String> strings = Tool.readFile("book.txt");
        System.out.println("请输入书名进行借阅:");
        Scanner s=new Scanner(System.in);
        String name =s.nextLine();
        for(int index=strings.size()-1;index>=0; index--) {
            String string = strings.get(index);
            String bookId = string.substring(string.indexOf("id=") + 3, string.indexOf(","));
            String bookName = string.substring(string.indexOf("name=") +5, string.indexOf(", author"));
            //通过name查找

            if (bookName.equals(name)) {
                ArrayList<String> borrows = Tool.readFile("borrow.txt");
                for(int i=borrows.size()-1;i>=0; i--){
                    String bo = borrows.get(i);
                    //通过id查找
                    if (bo.substring(bo.indexOf("bookId=") + 7).equals(bookId) && bo.substring(bo.indexOf("userId=") + 7,bo.indexOf(", bookId")).equals(user.getId()+"")) {
                        System.out.println("已借过这本咯");
                        return;
                    }
                }

                Integer number = Integer.valueOf(string.substring(string.indexOf("number=") + 7));
                if (number>0){
                    number--;
                    String replace = string.replace("number="+(number+1) , "number="+number);
                    strings.remove(string);
                    strings.add(replace);
                    System.out.println("借阅成功");
                    Borrow borrow = new Borrow();
                    borrow.setId(Tool.getID());
                    borrow.setBookId(Integer.valueOf(bookId));
                    borrow.setUserId(user.getId());
                    Tool.writeFile(borrow.toString(),"borrow.txt");
                }else {
                    System.out.println("无法借阅");
                }
            }
        }
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        Tool.coverWriteFile(str,"book.txt");
    }

    /**
     *
     * 还书
     *
     */
    public static void returnBook(User user){
        ArrayList<String> strings = Tool.readFile("borrow.txt");
        ArrayList<String> books = Tool.readFile("book.txt");
        System.out.println("请输入借阅名字进行归还:");
        Scanner s=new Scanner(System.in);
        String bookId = "";
        String id = "";
        String finalId = "";
        String name = s.nextLine();
        for(int index=books.size()-1;index>=0; index--){
            String string = books.get(index);
            //通过name查找bookId
            if (string.substring(string.indexOf("name=") + 5, string.indexOf(", author")).equals(name)) {
                id =string.substring(string.indexOf("id=") + 3, string.indexOf(","));
            }
        }
        for(int index=strings.size()-1;index>=0; index--){
            String string = strings.get(index);
            //通过bookId和userId
            if (string.substring(string.indexOf("bookId=") + 7).equals(id) && string.substring(string.indexOf("userId=") + 7,string.indexOf(", bookId")).equals(user.getId()+"")) {
                finalId =  string.substring(string.indexOf("id=") + 3, string.indexOf(","));
            }
        }
        String finalId1 = finalId;
        strings.removeIf(string -> string.substring(string.indexOf("id=") + 3, string.indexOf(",")).equals(finalId1));

        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }

        Tool.coverWriteFile(str,"borrow.txt");
        for(int index=books.size()-1;index>=0; index--){
            String string = books.get(index);
            //通过id查找
            if (string.substring(string.indexOf("id=") + 3, string.indexOf(",")).equals(id)) {
                String substring = string.substring(string.indexOf("number=") + 7);
                Integer number = Integer.valueOf(substring);
                number++;
                String replace = string.replace("number="+substring, "number="+number);
                books.remove(string);
                books.add(replace);
                System.out.println("归还成功！！");
            }
        }
        str = "";
        for (int i = 0; i < books.size(); i++) {
            str = str + books.get(i)+ "\n";
        }

        Tool.coverWriteFile(str,"book.txt");
    }

    /**
     *
     * 查看借阅记录
     *
     */
    public static void showBorrowBook(User user){
        ArrayList<String> strings = Tool.readFile("borrow.txt");
        ArrayList<String> books = Tool.readFile("book.txt");
        for(int index=strings.size()-1;index>=0; index--) {
            String string = strings.get(index);
            String userId = string.substring(string.indexOf("userId=") + 7, string.indexOf(", bookId"));
            if (userId.equals(user.getId()+"")){
                String bookId = string.substring(string.indexOf("bookId=")+7);
                for (int i=books.size()-1;i>=0; i--){
                    String book = books.get(i);
                    if (book.substring(book.indexOf("id=")+ 3, book.indexOf(",")).equals(bookId)) {
                        System.out.println("id="+string.substring(string.indexOf("id=") + 3, string.indexOf(", userId"))+",name="+book.substring(book.indexOf("name=") + 5, book.indexOf(",", book.indexOf("name="))));
                    }
                }
            }
        }
    }

}
