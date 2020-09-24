package cn.kgc.entity;

public class Goods {
    private int gid;
    private String gname;
    private double gprice;
    private Integer gstock;
    private String ginf;

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gstock=" + gstock +
                ", ginf='" + ginf + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }

    public String getGinf() {
        return ginf;
    }

    public void setGinf(String ginf) {
        this.ginf = ginf;
    }

    public Goods(int gid, String gname, double gprice, Integer gstock, String ginf) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gstock = gstock;
        this.ginf = ginf;
    }
}
