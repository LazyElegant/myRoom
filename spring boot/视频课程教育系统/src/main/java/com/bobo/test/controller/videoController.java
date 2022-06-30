package com.bobo.test.controller;


import com.bobo.test.pojo.*;
import com.bobo.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
public class videoController {

    @Autowired
    VideoService videoService;
    @Autowired
    classesService classesService;
    @Autowired
    WatchHistoryService watchHistoryService;
    @Autowired
    commentService commentService;
    @Autowired
    coursewareService coursewareService;
    @Autowired
    wordService wordService;

    @GetMapping("/video")
    public String toVideo(Model model , HttpSession session, String cm){
        User user = (User) session.getAttribute("user");
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        Video videoById = videoService.getVideoById(Long.valueOf(cm));
        int max = videoById.getNum();
        boolean count = false;
        if (max == 1){
        count =true;
        }


        List<Video> videoByClassesId = videoService.getVideoByClassesId(videoById.getClasses_id());
        List<WatchHistory> watchHistoryByUserId = watchHistoryService.getWatchHistoryByUserId(user.getId());
        for (Video video : videoByClassesId) {
            for (WatchHistory watchHistory : watchHistoryByUserId) {
                if (video.getId().equals(watchHistory.getVideo_id())) {
                    if (video.getNum()+1 >= max) {
                        count =true;
                    }
                }
            }
        }

        if (count){

            videoById.getClasses_id();
            model.addAttribute("video",videoById);
            WatchHistory watchHistory = new WatchHistory();
            watchHistory.setId(Long.valueOf(u_word));
            watchHistory.setUser_id(user.getId());
            watchHistory.setVideo_id(Long.valueOf(cm));
            String format = "YYYY-MM-dd hh:mm:ss";
            String formatDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
            watchHistory.setCreate_time(formatDateTime);
            watchHistoryService.insertWatchHistory(watchHistory);

            List<comment> comments = commentService.queryCommentById(Long.valueOf(cm));
            if(!comments.isEmpty()){
                model.addAttribute("reviews",comments);
            }
            String courseware = coursewareService.getCourseware(Long.valueOf(cm));
            if (courseware != null) {
                model.addAttribute("courseware",courseware);
            }
            word word = wordService.getWord(Long.valueOf(cm), user.getId());
            if (word != null) {
                model.addAttribute("word",word);
            }
            return "video";
        }else {

            model.addAttribute("classes",classesService.listClassesById(videoById.getClasses_id()));
            model.addAttribute("videos",videoService.getVideoByClassesId(videoById.getClasses_id()));
            model.addAttribute("msg",1);

            return "classes";
        }
    }

    @RequestMapping("/videoPlun")
    public String plun(String num,String pluntext,String name_num,String name, Model model){
        Calendar calendar= Calendar.getInstance();
        String id = "";
        int nu = 0;
        for(int i = 0; i < 9; i++) {
            nu = (int)(Math.random()*10);
            id = id + nu;
        }
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment review = new comment(Long.valueOf(id),Long.valueOf(num),Long.valueOf(name_num),dateFormat.format(calendar.getTime()),pluntext);
        commentService.addComment(review);
        return "redirect:/video?cm="+num;
    }
    @RequestMapping("/video/download")
    public String download(Long id, HttpServletResponse response){
        String courseware = coursewareService.getCourseware(id);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + courseware);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\static" + courseware )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/video?cm="+id;

    }
    private Long createId(){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 9; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        return Long.valueOf(u_word);
    }
    @RequestMapping("/word")
    public String word(MultipartFile myfile,String num,String name_num){
        System.out.println(myfile);
        String fileExt = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf(".") + 1)
                .toLowerCase();
        String pikId = UUID.randomUUID().toString().replaceAll("-", "");
        String newVidoeName = pikId + "." + fileExt;
        String fileUrl = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\file";
        File fileSave = new File(fileUrl, newVidoeName);
        try {
            myfile.transferTo(fileSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordService.addWord(new word(createId(),"/file/"+newVidoeName,Long.valueOf(num),Long.valueOf(name_num)));

        return "redirect:/video?cm="+num;
    }


}
