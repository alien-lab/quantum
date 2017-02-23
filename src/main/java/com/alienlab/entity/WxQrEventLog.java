package com.alienlab.entity;

import javax.persistence.*;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_qr_event_log", schema = "alienlab_wechat")
public class WxQrEventLog {
    private String openid;
    private String unionid;
    private String eventtime;
    private String qrkey;
    private long id;

    @Basic
    @Column(name = "Openid", nullable = false, length = 32)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "Unionid", nullable = false, length = 32)
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Basic
    @Column(name = "eventtime", nullable = false, length = 18)
    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    @Basic
    @Column(name = "qrkey", nullable = false, length = 10)
    public String getQrkey() {
        return qrkey;
    }

    public void setQrkey(String qrkey) {
        this.qrkey = qrkey;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WxQrEventLog that = (WxQrEventLog) o;

        if (id != that.id) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
        if (eventtime != null ? !eventtime.equals(that.eventtime) : that.eventtime != null) return false;
        if (qrkey != null ? !qrkey.equals(that.qrkey) : that.qrkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openid != null ? openid.hashCode() : 0;
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (eventtime != null ? eventtime.hashCode() : 0);
        result = 31 * result + (qrkey != null ? qrkey.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
