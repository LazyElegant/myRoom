package com.cm.util;

/**
 * @Author admin
 * @create 2022/5/23 22:10
 */
public class Tool {

    public static Integer getID(){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 6; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        return Integer.valueOf(u_word);
    }
}
