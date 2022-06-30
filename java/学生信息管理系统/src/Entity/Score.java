package Entity;

public class Score {
    private Integer sid;
    private Integer cid;
    private Float score;

    public Score() {
    }

    public Score(Integer sid, Integer cid, Float score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "学生id=" + sid +
                ", 课程id=" + cid +
                ", 成绩=" + score;
    }
}
