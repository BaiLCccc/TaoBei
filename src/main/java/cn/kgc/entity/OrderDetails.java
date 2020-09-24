package cn.kgc.entity;

//订单详情实体类
public class OrderDetails {
    private Integer id;
    private Integer oid;//订单编号
    private Integer gid;//商品编号
    private Integer gnum;//商品数量

    public OrderDetails(Integer id, Integer oid, Integer gid, Integer gnum) {
        this.id = id;
        this.oid = oid;
        this.gid = gid;
        this.gnum = gnum;
    }

    public OrderDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", oid=" + oid +
                ", gid=" + gid +
                ", gnum=" + gnum +
                '}';
    }
}
