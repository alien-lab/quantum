package com.alienlab.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_user_message", schema = "alienlab_wechat")
public class WxUserMessage {
    private String openid;
    private String unionid;
    private String messagetype;
    private String messagetime;
    private String messagecontent;
    private String messagemedia;
    private Timestamp datatime;
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
    @Column(name = "Unionid", nullable = true, length = 32)
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Basic
    @Column(name = "Messagetype", nullable = false, length = 30)
    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

    @Basic
    @Column(name = "Messagetime", nullable = false, length = 18)
    public String getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }

    @Basic
    @Column(name = "Messagecontent", nullable = true, length = 1000)
    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    @Basic
    @Column(name = "Messagemedia", nullable = true, length = 500)
    public String getMessagemedia() {
        return messagemedia;
    }

    public void setMessagemedia(String messagemedia) {
        this.messagemedia = messagemedia;
    }

    @Basic
    @Column(name = "datatime", nullable = true)
    public Timestamp getDatatime() {
        return datatime;
    }

    public void setDatatime(Timestamp datatime) {
        this.datatime = datatime;
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

        WxUserMessage that = (WxUserMessage) o;

        if (id != that.id) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
        if (messagetype != null ? !messagetype.equals(that.messagetype) : that.messagetype != null) return false;
        if (messagetime != null ? !messagetime.equals(that.messagetime) : that.messagetime != null) return false;
        if (messagecontent != null ? !messagecontent.equals(that.messagecontent) : that.messagecontent != null)
            return false;
        if (messagemedia != null ? !messagemedia.equals(that.messagemedia) : that.messagemedia != null) return false;
        if (datatime != null ? !datatime.equals(that.datatime) : that.datatime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openid != null ? openid.hashCode() : 0;
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (messagetype != null ? messagetype.hashCode() : 0);
        result = 31 * result + (messagetime != null ? messagetime.hashCode() : 0);
        result = 31 * result + (messagecontent != null ? messagecontent.hashCode() : 0);
        result = 31 * result + (messagemedia != null ? messagemedia.hashCode() : 0);
        result = 31 * result + (datatime != null ? datatime.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
