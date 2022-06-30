
import book.Book;
import book.Borrow;
import service.BookService;
import service.BorrowService;
import service.UserService;
import user.User;
import utile.Tool;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManage {

    public static void main(String[] args) {
        int i;
        Scanner s=new Scanner(System.in);
        User user = null;
        do {
            indexMenu();
            i = s.nextInt();
            switch (i) {
                case 1:
                    user = UserService.login();
                    break;
                case 2:
                    UserService.register();
                    break;
                case 3:
                    System.out.println("感谢使用");
                    return;
            }
            // 判断是否登录
        }while (user == null);


        if (user.getStatus()==1) {
            do {
                menu(user);
                i = s.nextInt();
                switch (i) {
                    case 1:
                        BookService.showBook();
                        break;
                   case 2:
                       BookService.addBook();
                       break;
                   case 3:
                       BookService.deleteBook();
                       break;
                   case 4:
                       BookService.updateBook();
                       break;
                   case 5:
                       BookService.getBookByName();
                       break;
                   case 6:
                       System.out.println("已退出登录");
                       break;
                   default:
                       System.out.println("输入不正确请重新输入!!");
                }
            }while (i != 6);
        }else {
            do {
                menu(user);
                i = s.nextInt();
                switch (i) {
                    case 1:
                        BookService.showBook();
                        break;
                    case 2:
                        BookService.getBookByName();
                        break;
                    case 3:
                        BorrowService.borrowBook(user);
                        break;
                    case 4:
                        BorrowService.returnBook(user);
                        break;
                    case 5:
                        BorrowService.showBorrowBook(user);
                        break;
                    case 6:
                        System.out.println("已退出登录");
                        break;
                    default:
                        System.out.println("输入不正确请重新输入!!");
                }
            }while (i != 6);
        }
    }

    /**
     *
     * 菜单
     *
     */
    public static void menu(User user){
        if (user.getStatus() == 1){

            System.out.println("----------------------欢迎您："+ user.getName()+"(管理员)-----------------------");
            System.out.println("------------1.查询所有书籍信息");
            System.out.println("------------2.添加书籍");
            System.out.println("------------3.删除书籍");
            System.out.println("------------4.修改书籍信息");
            System.out.println("------------5.通过名字查询书籍");
            System.out.println("------------6.退出登录");
        }else {
            System.out.println("----------------------欢迎您："+ user.getName()+"(用户)-----------------------");
            System.out.println("------------1.查询所有书籍信息");
            System.out.println("------------2.通过名字查询书籍");
            System.out.println("------------3.借阅图书");
            System.out.println("------------4.归还图书");
            System.out.println("------------5.查看已借阅的图书");
            System.out.println("------------6.退出登录");
        }
    }
    public static void indexMenu(){
        System.out.println("---------------------------图书管理系统---------------------------");
        System.out.println("------------1.登录");
        System.out.println("------------2.注册");
        System.out.println("------------3.退出系统");
    }

}
