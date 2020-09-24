package cn.kgc.entity;

public class Order {

    private int id;
    private int oid;
    private int uid;
    private double totalprice;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", oid=" + oid +
                ", uid=" + uid +
                ", totalprice=" + totalprice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Order(int id, int oid, int uid, double totalprice) {
        this.id = id;
        this.oid = oid;
        this.uid = uid;
        this.totalprice = totalprice;
    }

    public Order() {
    }
}
