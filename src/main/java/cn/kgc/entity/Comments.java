package cn.kgc.entity;

import java.util.Date;

public class Comments {
    private int cid;
    private int gid;
    private int uid;
    private double score;
    private Date date;
    private String content;

    public Comments() {
    }

    public Comments(int cid, int gid, int uid, double score, Date date, String content) {
        this.cid = cid;
        this.gid = gid;
        this.uid = uid;
        this.score = score;
        this.date = date;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "cid=" + cid +
                ", gid=" + gid +
                ", uid=" + uid +
                ", score=" + score +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
