package cn.kabuto.ssm.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer gid;

    private String gname;

    private BigDecimal newprice;

    private BigDecimal oldprice;

    private String gdescription;

    private Byte state;

    private Integer uid;

    private Integer cid;

    private Date starttime;

    private Date endtime;

    private Date flashtime;

    private Byte salestate;

    private Date buytime;

    private Byte uploadstate;

    private String gcondition;

    private String salereason;

    private String buyway;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public BigDecimal getNewprice() {
        return newprice;
    }

    public void setNewprice(BigDecimal newprice) {
        this.newprice = newprice;
    }

    public BigDecimal getOldprice() {
        return oldprice;
    }

    public void setOldprice(BigDecimal oldprice) {
        this.oldprice = oldprice;
    }

    public String getGdescription() {
        return gdescription;
    }

    public void setGdescription(String gdescription) {
        this.gdescription = gdescription == null ? null : gdescription.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getFlashtime() {
        return flashtime;
    }

    public void setFlashtime(Date flashtime) {
        this.flashtime = flashtime;
    }

    public Byte getSalestate() {
        return salestate;
    }

    public void setSalestate(Byte salestate) {
        this.salestate = salestate;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public Byte getUploadstate() {
        return uploadstate;
    }

    public void setUploadstate(Byte uploadstate) {
        this.uploadstate = uploadstate;
    }

    public String getGcondition() {
        return gcondition;
    }

    public void setGcondition(String gcondition) {
        this.gcondition = gcondition == null ? null : gcondition.trim();
    }

    public String getSalereason() {
        return salereason;
    }

    public void setSalereason(String salereason) {
        this.salereason = salereason == null ? null : salereason.trim();
    }

    public String getBuyway() {
        return buyway;
    }

    public void setBuyway(String buyway) {
        this.buyway = buyway == null ? null : buyway.trim();
    }
}