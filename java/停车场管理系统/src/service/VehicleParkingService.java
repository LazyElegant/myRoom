package service;

import model.VehicleParking;
import utile.Tool;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class VehicleParkingService {
    /**
     *
     * 列出所有停车信息
     *
     */
    public static void list(){
        LinkedList<String> strings = Tool.readFile("park.txt");
        for (String string : strings) {
            System.out.println(string);
        }
    }


    /**
     *
     * 通过id查询
     *
     */
    public static void getParkById(){
        LinkedList<String> strings = Tool.readFile("park.txt");
        System.out.println("请输入查找id:");
        Scanner s=new Scanner(System.in);
        String id = s.nextLine();
        boolean con = true;
        for (String string : strings) {
            String substring = string.substring(string.indexOf("id=") + 3, string.indexOf(","));
            if(substring.equals(id)){
                con=false;
                System.out.println(string);
            }
        }

        if (con){
            System.out.println("并没有查找到！！");
        }
    }
    /**
     *
     * 通过车牌号查询
     *
     */
    public static void getParkByNumber(){
        LinkedList<String> strings = Tool.readFile("park.txt");
        System.out.println("请输入查找车牌号:");
        Scanner s=new Scanner(System.in);
        String number = s.nextLine();
        boolean con = true;
        for (String string : strings) {
            String substring = string.substring(string.indexOf("number=") + 7, string.indexOf(", type"));
            if(substring.equals(number)){
                con=false;
                System.out.println(string);
            }
        }

        if (con){
            System.out.println("并没有查找到！！");
        }
    }
    /**
     *
     * 删除所有停车信息
     *
     */
    public static void delete(){
        LinkedList<String> strings = Tool.readFile("park.txt");
        System.out.println("请输入id进行删除:");
        Scanner s=new Scanner(System.in);
        String id = s.nextLine();
        //通过id查找并删除
        strings.removeIf(string -> string.substring(string.indexOf("id=") + 3, string.indexOf(",")).equals(id));
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        Tool.coverWriteFile(str,"park.txt");
    }

    /**
     *
     * 停车
     *
     */
    public static void insertVehicleParking(){
        VehicleParking park = new VehicleParking();
        park.setId(Tool.getID());
        Scanner s=new Scanner(System.in);
        System.out.println("请输入车牌号:");
        park.setNumber(s.nextLine());
        System.out.println("请输入车辆类型 1：中小型车辆 2：大型车 3：新能源车:");
        park.setType(Integer.valueOf(s.nextLine()));
        System.out.println("请输入车辆是否为包月车： 1: 是 2：否");
        park.setMonth(Integer.valueOf(s.nextLine()));
        park.setStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        park.setPresent(1);
        Tool.writeFile(park.toString(),"park.txt");
    }

    /**
     *
     * 离开停车场
     *
     */
    public static void leave(){
        System.out.println("您要开哪辆车离开停车场呢（请输入车牌号）?");
        Scanner s=new Scanner(System.in);
        String number = s.nextLine();
        LinkedList<String> strings = Tool.readFile("park.txt");
        for (String string : strings) {
            String substring = string.substring(string.indexOf("number=") + 7, string.indexOf(", type"));
            String present = string.substring(string.indexOf("present=") + 8);
            if (substring.equals(number) && present.equals("1")){
                int month = Integer.parseInt(string.substring(string.indexOf("month=") + 6, string.indexOf(", startDate")));
                int type = Integer.parseInt(string.substring(string.indexOf("type=") + 5, string.indexOf(", month")));
                LocalDateTime startDate = LocalDateTime.parse(string.substring(string.indexOf("startDate=") + 10, string.indexOf(", endDate")), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime endDate = LocalDateTime.now();
                Duration duration = Duration.between(startDate,endDate);
                long minu = duration.toMinutes();
                int price = 0;
                if (month ==1  && type ==1 ){
                    price = 480;
                    System.out.println("因该车为包月车，故只需要缴纳包月费:480元");
                }else if(month ==1  && type ==2 ){
                    price = 960;
                    System.out.println("因该车为包月车，故只需要缴纳包月费:960元");
                }else if (month ==1  && type ==3 ){
                    price = 360;
                    System.out.println("因该车为包月车，故只需要缴纳包月费:360元");
                }else if (month ==2  && type ==1 && minu < 30 || month ==2  && type ==2 && minu < 30  || month ==2  && type ==3 && minu < 120){
                    price = 0;
                    System.out.println("因未超过停放时长，故无须缴纳停车费");
                }else if (month == 2 && type == 1 && minu < 180){
                    price = 5;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 1 && minu < 18 *60 ){

                    price = (int) (5+  (minu - 180 )/ 60) +1;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 1 && minu < 24 *60 ){
                    price = 20;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 1 && minu > 24 *60 ){
                    while (minu >24 *60){
                        minu = minu - 24*60;
                        price = price + 20;
                    }
                    price = price + (int) (5+  (minu - 180 )/ 60)+1;

                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 2 && minu < 120 ){
                    price = 10;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 2 && minu < 18*60 ){
                    price = (int) (10+  (minu - 120 )/ 60) +3;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 2 && minu < 24 *60 ){
                    price = 60;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 2 && minu > 24 *60 ){
                    while (minu >24 *60){
                        minu = minu - 24*60;
                        price = price + 60;
                    }
                    price = price + (int) (10+  (minu - 120 )/ 60)+3;

                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 3 && minu < 4*60 ){
                    price = 3;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 3 && minu < 21*60 ){
                    price =  (int) (3+  (minu - 4*60 )/ 60) +1;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 3 && minu < 24*60 ){
                    price =  20;
                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }else if (month == 2 && type == 3 && minu > 24 *60 ){
                    while (minu >24 *60){
                        minu = minu - 24*60;
                        price = price + 20;
                    }
                    price = price + (int) (3+  (minu - 4*60 )/ 60) +1;

                    System.out.println("本次停车时长为："+minu+"分钟，费用为："+price);
                }

                String date = string.substring(string.indexOf("endDate="), string.indexOf(", price"));
                String newDate = "endDate=" + endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String replace = string.replace(date, newDate);
                strings.remove(string);
                String oldPrice = replace.substring(replace.indexOf("price="), replace.indexOf(", present"));
                String newPrice = "price=" +price;
                String newReplace = replace.replace(oldPrice, newPrice);
                newReplace = newReplace.replace("present=1","present=2");
                strings.add(newReplace);
            }
        }

        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            str = str + strings.get(i)+ "\n";
        }
        //将输入的信息输出到user.txt中
        Tool.coverWriteFile(str,"park.txt");
    }


}
