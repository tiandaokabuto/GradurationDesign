package cn.kabuto.ssm.pojo;

public class Orderitem {
    private Integer iid;

    private Double subtotal;

    private Integer gid;

    private String oid;

    private Byte itemstate;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Byte getItemstate() {
        return itemstate;
    }

    public void setItemstate(Byte itemstate) {
        this.itemstate = itemstate;
    }
}