package com.mytian.lb.bean;

import com.core.openapi.OpenApiSimpleResult;

/**
 * 用户信息
 * Created by bin.teng on 2015/10/28.
 */
public class ParentBean extends OpenApiSimpleResult {
    private String uid;
    private String token;
    private String phone;
    private String alias;
    private int sex;
    private long birthday;
    private String headThumb;
    private String sysThumbId;
    private String thumbType;


    public String getThumbType() {
        return thumbType;
    }

    public void setThumbType(String thumbType) {
        this.thumbType = thumbType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getHeadThumb() {
        return headThumb;
    }

    public void setHeadThumb(String headThumb) {
        this.headThumb = headThumb;
    }

    public String getSysThumbId() {
        return sysThumbId;
    }

    public void setSysThumbId(String sysThumbId) {
        this.sysThumbId = sysThumbId;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", phone='" + phone + '\'' +
                ", alias='" + alias + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", headThumb='" + headThumb + '\'' +
                ", sysThumbId='" + sysThumbId + '\'' +
                ", thumbType='" + thumbType + '\'' +
                '}';
    }
}