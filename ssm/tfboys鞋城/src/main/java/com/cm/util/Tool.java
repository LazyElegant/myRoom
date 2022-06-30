package com.cm.util;

import com.cm.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author admin
 */
public class Tool{

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

    public static Integer getID(){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 6; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        return Integer.valueOf(u_word);
    }


    public static String createPictures(MultipartFile pictures){
        String filename = pictures.getOriginalFilename();
        String prefix = filename.substring(filename.lastIndexOf(".") + 1);
        String destFilename = UUID.randomUUID().toString().replace("-", "") + "." + prefix;
        String fileUrl = "C:\\Users\\admin\\Desktop\\SSM\\src\\main\\webapp\\img";
        File destImage = new File(fileUrl, destFilename);
        try {
            pictures.transferTo(destImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "../img/" + destFilename;
    }

}