package com.bobo.test.pojo;

/**
 * @Author admin
 * @create 2021/5/9 17:02
 */
public class Period {
    private Long id;
    private String create_time;
    private Long period;
    private Long user_id;
    private Long video_id;
    private String Time;
    private String video_name;

    public Period() {
    }

    public Period(Long id, String create_time, Long period, Long user_id, Long video_id) {
        this.id = id;
        this.create_time = create_time;
        this.period = period;
        this.user_id = user_id;
        this.video_id = video_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", create_time='" + create_time + '\'' +
                ", period=" + period +
                ", user_id=" + user_id +
                ", video_id=" + video_id +
                ", Time='" + Time + '\'' +
                '}';
    }
}
