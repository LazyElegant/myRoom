package com.bobo.test.controller;

import com.bobo.test.pojo.Period;
import com.bobo.test.pojo.User;
import com.bobo.test.pojo.Video;
import com.bobo.test.service.PeriodService;
import com.bobo.test.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static java.lang.String.valueOf;

@Controller
public class PeriodController {

    @Autowired
    PeriodService periodService;
    @Autowired
    VideoService videoService;

    @RequestMapping("/toPeriod")
    public String toPeriod( HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        List<Period> periods = periodService.getPeriod(user.getId());
        for (Period period : periods) {
            Date date = new Date(period.getPeriod()  * 1000);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            period.setTime(sdf.format(date));
            period.setVideo_name(videoService.getVideoById(period.getVideo_id()).getVideo_name());
        }
        model.addAttribute("periods", periods);
        return "Period";
    }

}
