package com.alienlab.entity;

import javax.persistence.*;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_pos_event_log", schema = "alienlab_wechat")
public class WxPosEventLog {
    private String openid;
    private String unionid;
    private String eventtime;
    private Double latitude;
    private Double longitude;
    private Double precision;
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
    @Column(name = "Latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "Precision", nullable = true, precision = 0)
    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
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

        WxPosEventLog that = (WxPosEventLog) o;

        if (id != that.id) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
        if (eventtime != null ? !eventtime.equals(that.eventtime) : that.eventtime != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (precision != null ? !precision.equals(that.precision) : that.precision != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openid != null ? openid.hashCode() : 0;
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (eventtime != null ? eventtime.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (precision != null ? precision.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
