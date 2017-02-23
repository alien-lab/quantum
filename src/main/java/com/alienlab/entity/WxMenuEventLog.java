package com.alienlab.entity;

import javax.persistence.*;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_menu_event_log", schema = "alienlab_wechat")
public class WxMenuEventLog {
    private String openid;
    private String unionid;
    private String eventtime;
    private String menukey;
    private String eventtype;
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
    @Column(name = "eventtime", nullable = false, length = 18)
    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }

    @Basic
    @Column(name = "menukey", nullable = false, length = 10)
    public String getMenukey() {
        return menukey;
    }

    public void setMenukey(String menukey) {
        this.menukey = menukey;
    }

    @Basic
    @Column(name = "eventtype", nullable = false, length = 10)
    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
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

        WxMenuEventLog that = (WxMenuEventLog) o;

        if (id != that.id) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
        if (eventtime != null ? !eventtime.equals(that.eventtime) : that.eventtime != null) return false;
        if (menukey != null ? !menukey.equals(that.menukey) : that.menukey != null) return false;
        if (eventtype != null ? !eventtype.equals(that.eventtype) : that.eventtype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openid != null ? openid.hashCode() : 0;
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (eventtime != null ? eventtime.hashCode() : 0);
        result = 31 * result + (menukey != null ? menukey.hashCode() : 0);
        result = 31 * result + (eventtype != null ? eventtype.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
