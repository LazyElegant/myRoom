package Entity;

public class Course {
    private Integer cid;
    private String cname;
    private Integer tid;
    private String stuClass;

    public Course() {
    }

    public Course(Integer cid, String cname, Integer tid, String stuClass) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.stuClass = stuClass;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public String toString() {
        return "课程id=" + cid +
                ", 课程='" + cname + '\'' +
                ", 老师id=" + tid +
                ", 上课班级='" + stuClass;
    }
}
