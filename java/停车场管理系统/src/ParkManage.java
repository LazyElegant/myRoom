
import service.UserService;
import service.VehicleParkingService;
import user.User;

import java.util.Scanner;

public class ParkManage {

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
                        UserService.updatePassword(user);
                        break;
                    case 2:
                       UserService.resetPassword();
                       break;
                    case 3:
                        VehicleParkingService.list();
                       break;
                    case 4:
                        VehicleParkingService.delete();
                       break;
                    case 5:
                        VehicleParkingService.getParkById();
                       break;
                    case 6:
                        VehicleParkingService.getParkByNumber();
                        break;
                    case 7:
                       System.out.println("已退出登录");
                       break;
                   default:
                       System.out.println("输入不正确请重新输入!!");
                }
            }while (i != 7);
        }else {
            do {
                menu(user);
                i = s.nextInt();
                switch (i) {
                    case 1:
                        VehicleParkingService.insertVehicleParking();
                        break;
                    case 2:
                        VehicleParkingService.leave();
                        break;
                    case 3:
                        UserService.updatePassword(user);
                        break;
                    case 4:
                        System.out.println("已退出登录");
                        break;
                    default:
                        System.out.println("输入不正确请重新输入!!");
                }
            }while (i != 4);
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
            System.out.println("------------1.修改密码");
            System.out.println("------------2.重置用户密码");
            System.out.println("------------3.显示所有停车信息");
            System.out.println("------------4.删除停车信息");
            System.out.println("------------5.通过Id查询停车信息");
            System.out.println("------------6.通过车牌号查询停车信息");
            System.out.println("------------7.退出登录");

        }else {
            System.out.println("----------------------欢迎您："+ user.getName()+"(用户)-----------------------");
            System.out.println("------------1.停车");
            System.out.println("------------2.离开停车场");
            System.out.println("------------3.修改密码");
            System.out.println("------------4.退出登录");
        }
    }
    public static void indexMenu(){
        System.out.println("---------------------------停车场管理系统---------------------------");
        System.out.println("------------1.登录");
        System.out.println("------------2.注册");
        System.out.println("------------3.退出系统");
    }

}
