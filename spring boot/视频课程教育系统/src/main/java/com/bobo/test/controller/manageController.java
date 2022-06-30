package com.bobo.test.controller;

import com.bobo.test.config.MarkDownConfig;
import com.bobo.test.pojo.*;
import com.bobo.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author admin
 * @create 2021/4/24 21:38
 */
@Controller
public class manageController{
    @Autowired
    classesService classesService;
    @Autowired
    VideoService videoService;
    @Autowired
    coursewareService coursewareService;
    @Autowired
    wordService wordService;

    @RequestMapping("/classManage")
    public String toclassManage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("classes",classesService.listClassesBySpecialtyId(user.getSpecialty_id()));
        return "classManage";
    }

    @RequestMapping("/classManage/deleteClass")
    public String deleteClass(String id){
        List<Video> videoByClassesId = videoService.getVideoByClassesId(Long.valueOf(id));
        for (Video video : videoByClassesId) {
            videoService.deleteVideo(video.getId());
        }
        classesService.deleteClass(Long.valueOf(id));
        return "redirect:/classManage";
    }
    @RequestMapping("/classManage/updateClass")
    public String updateClass(String id,Model model, HttpSession session){
        classes classes = classesService.listClassesById(Long.valueOf(id));
        model.addAttribute("UpdateClass",classes);
        return "updateClass";
    }

    @RequestMapping("/classManage/addClass")
    public String toAddClass(){
        return "updateClass";
    }
    @RequestMapping("/addClass")
    public String addClass(String pdUpdate, MultipartFile pictures, MultipartFile UpdatePictures,String btn,String text,String duration,Model model, HttpSession session) {

        String logo = null;
        String filename = "";
        boolean value = true;
        String id = null;
        if ("12".equals(pdUpdate)) {
            filename = pictures.getOriginalFilename();
            if (!(filename.length() > 0)) {
                filename = "/img/logo.png";
            }
        } else {
            filename = UpdatePictures.getOriginalFilename();
            if (!(filename.length() > 0)) {
                filename = classesService.listClassesById(Long.valueOf(pdUpdate)).getPhoto();
            }
            id = pdUpdate;
            value = false;
        }
        classes classes = classesService.listClassesById(Long.valueOf(pdUpdate));
        if (classes != null) {
            pdUpdate = classes.getPhoto();
        }
        if(!"/img/logo.png".equals(filename) && !filename.equals(pdUpdate)){

            String prefix = filename.substring(filename.lastIndexOf(".") + 1);
            String destFilename = UUID.randomUUID().toString().replace("-", "") + "." + prefix;
            String fileUrl = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
            File destImage = new File(fileUrl, destFilename);
            try {
                pictures.transferTo(destImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logo = "/img/" + destFilename;
        }else {
            logo = filename;
        }
        User user = (User) session.getAttribute("user");

        List<classes> classes1 = classesService.listClassesBySpecialtyId(user.getSpecialty_id());
        int max = 1;
        for (classes classes2 : classes1) {
            if (max < classes2.getNum()+1) {
                max = classes2.getNum()+1;
            }
        }
        if (value){
            classesService.addClass(new classes(createId(),btn,user.getSpecialty_id(),text,user.getId(),duration,0L,logo,max+1));
        }else {
            classes classes2 = classesService.listClassesById(Long.valueOf(id));
            classesService.updateClass(new classes(Long.valueOf(id),btn,user.getSpecialty_id(),text,user.getId(),duration,0L,logo,classes2.getNum()));
        }
        return "redirect:/classManage";
    }

    @RequestMapping("/word/download")
    public String download(Long id, HttpServletResponse response){
        String word = wordService.getWordById(id);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + word);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\static" + word )));
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
    @RequestMapping("/videoManage")
    public String tovideoManage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<classes> classes = classesService.listClassesBySpecialtyId(user.getSpecialty_id());
        List<Video> video = new ArrayList<>();
        for (classes aClass : classes) {
            video.addAll(videoService.getVideoByClassesId(aClass.getId()));
        }
        model.addAttribute("videos", video);
        return "videoManage";
    }

    @RequestMapping("/videoManage/deleteVideo")
    public String deleteVideo(String id){
        videoService.deleteVideo(Long.valueOf(id));
        return "redirect:/videoManage";
    }
    @ResponseBody
    @RequestMapping("/getClass")
    public List<classes> getClass(Model model,String id){
        return classesService.listClassesBySpecialtyId(Long.valueOf(id));
    }

    @RequestMapping("/addVideo")
    public String addVideo(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<classes> classifies = classesService.listClassesBySpecialtyId(user.getSpecialty_id());
        model.addAttribute("classifys", classifies);
        return "addVideo";
    }

    @RequestMapping("/uploading")
    public String uploading(MultipartFile myfile,Long id){
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
        Video videoById = videoService.getVideoById(id);
        videoService.updateVideo(1,id);
        coursewareService.addCourseware(new courseware(createId(),"/file/"+ newVidoeName,id));
        return "redirect:/videoManage";
    }


    private String savaVideo(MultipartFile file)
            throws IllegalStateException {
        Map<String,String> resultMap = new HashMap<>();
        try{
            //获取文件后缀
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                    .toLowerCase();
            // 重构文件名称
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            //保存视频
            String fileUrl = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\video";
            File fileSave = new File(fileUrl, newVidoeName);
            file.transferTo(fileSave);
            return  "/video/" + newVidoeName;
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("resCode","0");
            return  "resultMap";
        }
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


    @RequestMapping("/videoManage/wordManage")
    public String wordManage(Model model,Long id){
        model.addAttribute("words", wordService.listWordById(id));
        return "wordManage";
    }

    @RequestMapping("/addVideoR")
    public String addNews(HttpSession session,MultipartFile myfile, String btn, String classify, String classes, String name, String text){

        List<Video> videoByClassesId = videoService.getVideoByClassesId(Long.valueOf(classify));
        int max = 0;
        for (Video video : videoByClassesId) {
            if (max<video.getNum()) {
                max = video.getNum();
            }
        }
        LocalDateTime dateTime = LocalDateTime.now();
        videoService.addVideo(new Video(createId(),Long.valueOf(classes),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime),savaVideo(myfile),btn,text,max+1,0));
        return "redirect:/classManage";
    }

}
