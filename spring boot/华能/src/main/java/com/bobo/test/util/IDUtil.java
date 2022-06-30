package com.bobo.test.util;

/**
 * @Author admin
 * @create 2021/9/8 22:03
 */
public  class IDUtil {

    public static Long getID(){
        String num = "";
        for(int i = 0; i < 9; i++){
           num = num + (int) (Math.random()*(9-1)+1);
        }
        return Long.valueOf(num);
    }

}
