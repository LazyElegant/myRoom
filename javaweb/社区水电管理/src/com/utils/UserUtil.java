package com.utils;

import com.beans.User;

public class UserUtil {
    private static User USER;

    public static User getUSER() {
        return USER;
    }

    public static void setUSER(User USER) {
        UserUtil.USER = USER;
    }

    public static Integer  getUserID(){
        return USER!=null ? USER.getId(): null;
    }

}
