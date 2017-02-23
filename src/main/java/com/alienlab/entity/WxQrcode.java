package com.alienlab.entity;

import javax.persistence.*;

/**
 * Created by 橘 on 2016/12/26.
 */
@Entity
@Table(name = "wx_qrcode", schema = "alienlab_wechat")
public class WxQrcode {
    private long qrcodeId;
    private String qrcodeKey;
    private String qrcodeName;
    private String qrcodeCreatetime;
    private String qrcodeBegintime;
    private String qrcodeEndtime;
    private long infoId;

    @Id
    @Column(name = "Qrcode_id", nullable = false)
    public long getQrcodeId() {
        return qrcodeId;
    }

    public void setQrcodeId(long qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

    @Basic
    @Column(name = "Qrcode_key", nullable = false, length = 32)
    public String getQrcodeKey() {
        return qrcodeKey;
    }

    public void setQrcodeKey(String qrcodeKey) {
        this.qrcodeKey = qrcodeKey;
    }

    @Basic
    @Column(name = "Qrcode_name", nullable = false, length = 60)
    public String getQrcodeName() {
        return qrcodeName;
    }

    public void setQrcodeName(String qrcodeName) {
        this.qrcodeName = qrcodeName;
    }

    @Basic
    @Column(name = "Qrcode_createtime", nullable = false, length = 18)
    public String getQrcodeCreatetime() {
        return qrcodeCreatetime;
    }

    public void setQrcodeCreatetime(String qrcodeCreatetime) {
        this.qrcodeCreatetime = qrcodeCreatetime;
    }

    @Basic
    @Column(name = "Qrcode_begintime", nullable = false, length = 18)
    public String getQrcodeBegintime() {
        return qrcodeBegintime;
    }

    public void setQrcodeBegintime(String qrcodeBegintime) {
        this.qrcodeBegintime = qrcodeBegintime;
    }

    @Basic
    @Column(name = "Qrcode_endtime", nullable = false, length = 18)
    public String getQrcodeEndtime() {
        return qrcodeEndtime;
    }

    public void setQrcodeEndtime(String qrcodeEndtime) {
        this.qrcodeEndtime = qrcodeEndtime;
    }

    @Basic
    @Column(name = "Info_id", nullable = false)
    public long getInfoId() {
        return infoId;
    }

    public void setInfoId(long infoId) {
        this.infoId = infoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WxQrcode wxQrcode = (WxQrcode) o;

        if (qrcodeId != wxQrcode.qrcodeId) return false;
        if (infoId != wxQrcode.infoId) return false;
        if (qrcodeKey != null ? !qrcodeKey.equals(wxQrcode.qrcodeKey) : wxQrcode.qrcodeKey != null) return false;
        if (qrcodeName != null ? !qrcodeName.equals(wxQrcode.qrcodeName) : wxQrcode.qrcodeName != null) return false;
        if (qrcodeCreatetime != null ? !qrcodeCreatetime.equals(wxQrcode.qrcodeCreatetime) : wxQrcode.qrcodeCreatetime != null)
            return false;
        if (qrcodeBegintime != null ? !qrcodeBegintime.equals(wxQrcode.qrcodeBegintime) : wxQrcode.qrcodeBegintime != null)
            return false;
        if (qrcodeEndtime != null ? !qrcodeEndtime.equals(wxQrcode.qrcodeEndtime) : wxQrcode.qrcodeEndtime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (qrcodeId ^ (qrcodeId >>> 32));
        result = 31 * result + (qrcodeKey != null ? qrcodeKey.hashCode() : 0);
        result = 31 * result + (qrcodeName != null ? qrcodeName.hashCode() : 0);
        result = 31 * result + (qrcodeCreatetime != null ? qrcodeCreatetime.hashCode() : 0);
        result = 31 * result + (qrcodeBegintime != null ? qrcodeBegintime.hashCode() : 0);
        result = 31 * result + (qrcodeEndtime != null ? qrcodeEndtime.hashCode() : 0);
        result = 31 * result + (int) (infoId ^ (infoId >>> 32));
        return result;
    }
}
