package com.alienlab.entity;

import javax.persistence.*;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_media_log", schema = "alienlab_wechat")
public class WxMediaLog {
    private long mediaLogId;
    private String openid;
    private String unionid;
    private String mediaType;
    private String mediaDirection;
    private String mediaRemoteUrl;
    private long mediaSize;
    private String mediaName;
    private String mediaLocalUrl;
    private String mediaId;

    @Id
    @Column(name = "media_log_id", nullable = false)
    public long getMediaLogId() {
        return mediaLogId;
    }

    public void setMediaLogId(long mediaLogId) {
        this.mediaLogId = mediaLogId;
    }

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
    @Column(name = "Media_type", nullable = false, length = 30)
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Basic
    @Column(name = "Media_direction", nullable = false, length = 10)
    public String getMediaDirection() {
        return mediaDirection;
    }

    public void setMediaDirection(String mediaDirection) {
        this.mediaDirection = mediaDirection;
    }

    @Basic
    @Column(name = "Media_remote_url", nullable = false, length = 500)
    public String getMediaRemoteUrl() {
        return mediaRemoteUrl;
    }

    public void setMediaRemoteUrl(String mediaRemoteUrl) {
        this.mediaRemoteUrl = mediaRemoteUrl;
    }

    @Basic
    @Column(name = "Media_size", nullable = false)
    public long getMediaSize() {
        return mediaSize;
    }

    public void setMediaSize(long mediaSize) {
        this.mediaSize = mediaSize;
    }

    @Basic
    @Column(name = "Media_name", nullable = false, length = 100)
    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    @Basic
    @Column(name = "Media_local_url", nullable = false, length = 500)
    public String getMediaLocalUrl() {
        return mediaLocalUrl;
    }

    public void setMediaLocalUrl(String mediaLocalUrl) {
        this.mediaLocalUrl = mediaLocalUrl;
    }

    @Basic
    @Column(name = "Media_id", nullable = false, length = 32)
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WxMediaLog that = (WxMediaLog) o;

        if (mediaLogId != that.mediaLogId) return false;
        if (mediaSize != that.mediaSize) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
        if (mediaType != null ? !mediaType.equals(that.mediaType) : that.mediaType != null) return false;
        if (mediaDirection != null ? !mediaDirection.equals(that.mediaDirection) : that.mediaDirection != null)
            return false;
        if (mediaRemoteUrl != null ? !mediaRemoteUrl.equals(that.mediaRemoteUrl) : that.mediaRemoteUrl != null)
            return false;
        if (mediaName != null ? !mediaName.equals(that.mediaName) : that.mediaName != null) return false;
        if (mediaLocalUrl != null ? !mediaLocalUrl.equals(that.mediaLocalUrl) : that.mediaLocalUrl != null)
            return false;
        if (mediaId != null ? !mediaId.equals(that.mediaId) : that.mediaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mediaLogId ^ (mediaLogId >>> 32));
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (mediaType != null ? mediaType.hashCode() : 0);
        result = 31 * result + (mediaDirection != null ? mediaDirection.hashCode() : 0);
        result = 31 * result + (mediaRemoteUrl != null ? mediaRemoteUrl.hashCode() : 0);
        result = 31 * result + (int) (mediaSize ^ (mediaSize >>> 32));
        result = 31 * result + (mediaName != null ? mediaName.hashCode() : 0);
        result = 31 * result + (mediaLocalUrl != null ? mediaLocalUrl.hashCode() : 0);
        result = 31 * result + (mediaId != null ? mediaId.hashCode() : 0);
        return result;
    }
}
