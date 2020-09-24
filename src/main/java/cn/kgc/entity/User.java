package cn.kgc.entity;

public class User {
    private Integer uid;
    private String uname;
    private String upassword;
    private String uphone;
    private int uvalid; //有效标识
    private int udelid; //删除标识


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uvalid=" + uvalid +
                ", udelid=" + udelid +
                '}';
    }

    public int getUvalid() {
        return uvalid;
    }

    public void setUvalid(int uvalid) {
        this.uvalid = uvalid;
    }

    public int getUdelid() {
        return udelid;
    }

    public void setUdelid(int udelid) {
        this.udelid = udelid;
    }

    public User(Integer uid, String uname, String upassword, String uphone, int uvalid, int udelid) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.uphone = uphone;
        this.uvalid = uvalid;
        this.udelid = udelid;
    }
}