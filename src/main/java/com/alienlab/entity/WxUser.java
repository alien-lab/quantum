package com.alienlab.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_user", schema = "alienlab_wechat")
public class WxUser {
    private String userPhone;
    private String userStatus;
    private String openid;
    private String nickname;
    private String headerimg;
    private String sex;
    private String province;
    private String city;
    private String country;
    private String unionid;
    private Timestamp userTime;
    private String isadmin="0";
    private long id;

    @Basic
    @Column(name = "user_phone", nullable = true, length = 11)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_status", nullable = true, length = 3)
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "openid", nullable = true, length = 32)
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 100)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "headerimg", nullable = true, length = 500)
    public String getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(String headerimg) {
        this.headerimg = headerimg;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 10)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 60)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 60)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 60)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "unionid", nullable = true, length = 32)
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Basic
    @Column(name = "user_time", nullable = true)
    public Timestamp getUserTime() {
        return userTime;
    }

    public void setUserTime(Timestamp userTime) {
        this.userTime = userTime;
    }

    @Basic
    @Column(name = "isadmin", nullable = true)
    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
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

        WxUser wxUser = (WxUser) o;

        if (id != wxUser.id) return false;
        if (userPhone != null ? !userPhone.equals(wxUser.userPhone) : wxUser.userPhone != null) return false;
        if (userStatus != null ? !userStatus.equals(wxUser.userStatus) : wxUser.userStatus != null) return false;
        if (openid != null ? !openid.equals(wxUser.openid) : wxUser.openid != null) return false;
        if (nickname != null ? !nickname.equals(wxUser.nickname) : wxUser.nickname != null) return false;
        if (headerimg != null ? !headerimg.equals(wxUser.headerimg) : wxUser.headerimg != null) return false;
        if (sex != null ? !sex.equals(wxUser.sex) : wxUser.sex != null) return false;
        if (province != null ? !province.equals(wxUser.province) : wxUser.province != null) return false;
        if (city != null ? !city.equals(wxUser.city) : wxUser.city != null) return false;
        if (country != null ? !country.equals(wxUser.country) : wxUser.country != null) return false;
        if (unionid != null ? !unionid.equals(wxUser.unionid) : wxUser.unionid != null) return false;
        if (userTime != null ? !userTime.equals(wxUser.userTime) : wxUser.userTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userPhone != null ? userPhone.hashCode() : 0;
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (headerimg != null ? headerimg.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (userTime != null ? userTime.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
