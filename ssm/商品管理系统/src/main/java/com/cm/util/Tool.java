package com.cm.util;

import com.cm.model.User;

/**
 * @Author admin
 * @create 2022/5/23 22:10
 */
public class Tool {

    private static User USER;

    public static User getUSER() {
        return USER;
    }

    public static void setUSER(User USER) {
        Tool.USER = USER;
    }

    public static Integer  getUserID(){
        return USER!=null ? USER.getId(): null;
    }

    /**
     * 生成id
     * @return
     */
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
