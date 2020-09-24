package cn.kgc.entity;

public class Admin {
    private Integer aid;
    private String aname;
    private String apassword;
    private int pid;
    private int avalid; //有效标识
    private int adelid; //删除标识

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                ", pid=" + pid +
                ", avalid=" + avalid +
                ", adelid=" + adelid +
                '}';
    }

    public int getAvalid() {
        return avalid;
    }

    public void setAvalid(int avalid) {
        this.avalid = avalid;
    }

    public int getAdelid() {
        return adelid;
    }

    public void setAdelid(int adelid) {
        this.adelid = adelid;
    }

    public Admin(Integer aid, String aname, String apassword, int pid, int avalid, int adelid) {
        this.aid = aid;
        this.aname = aname;
        this.apassword = apassword;
        this.pid = pid;
        this.avalid = avalid;
        this.adelid = adelid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Admin(Integer aid, String aname, String apassword, int pid) {
        this.aid = aid;
        this.aname = aname;
        this.apassword = apassword;
        this.pid = pid;
    }

    public Admin() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }


}
