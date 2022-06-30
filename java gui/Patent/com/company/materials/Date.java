
//定义一个Date类，兼顾大月、小月和闰年2月等日期的计算，须包括方法tomorrow()和daysInMonth()。
package com.company.materials;

import java.util.Objects;

public class Date {
    private int year, month, day;
    final char SEPARATOR = '-';

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date (String date ){
        this.year=Integer.parseInt(date.substring(0,4));
        this.month=Integer.parseInt(date.substring(5,7));
        this.day=Integer.parseInt(date.substring(8,10));
    }


    public int daysInMonth() {
        switch (this.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (this.year % 4 == 0) {
                    return 29;
                } else
                    return 28;
        }
        return 0;
    }

    @Override
    public String toString() {
        return year +
                "-" + month +
                "-" + day;
    }

    public void tomorrow() {
        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) {
            if (this.day == 31) {
                this.month = month + 1;
                this.day = 1;
            } else this.day = day + 1;
        } else if (this.month == 12) {
            if (this.day == 31) {
                this.year = year + 1;
                this.month = 1;
                this.day = 1;
            } else this.day = day + 1;
        } else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
            if (this.day == 31) {
                this.month = month + 1;
                this.day = 1;
            } else this.day = day + 1;
        } else if (this.month == 2) {
            if (this.year % 4 == 0) {
                if (this.day == 29) {
                    this.month = month + 1;
                    this.day = 1;
                }
            } else if (this.day == 28) {
                this.month = month + 1;
                this.day = 1;
            } else this.day = day + 1;
        }
    }

    public static void main(String[] args) {
        Date d1 = new Date(2022, 12, 31);
        Date d2 = new Date(2022, 12, 31);
        System.out.println("今天是"+d1);
        d1.tomorrow();
        System.out.println("明天是"+d1);
        int a;
        a=d1.daysInMonth();
        System.out.println("这个月一共有"+a+"天");
        System.out.println(d1.equals(d2));
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(year,date.year) && Objects.equals(month,date.month) && Objects.equals(day, date.day);
    }


}



