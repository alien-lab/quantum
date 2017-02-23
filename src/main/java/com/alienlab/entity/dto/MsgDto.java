package com.alienlab.entity.dto;

import java.sql.Timestamp;

/**
 * Created by 橘 on 2016/12/30.
 */
public class MsgDto {
    private String openid;
    private String unionid;
    private String messagetype;
    private String messagetime;
    private String messagecontent;
    private String messagemedia;
    private Timestamp datatime;
    private long id;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public String getMessagemedia() {
        return messagemedia;
    }

    public void setMessagemedia(String messagemedia) {
        this.messagemedia = messagemedia;
    }

    public Timestamp getDatatime() {
        return datatime;
    }

    public void setDatatime(Timestamp datatime) {
        this.datatime = datatime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
