package com.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "AGREEMENT".
 */
public class Agreement {

    private Long id;
    private String title;
    private String appointId;
    private String icon;
    private java.util.Date date;

    public Agreement() {
    }

    public Agreement(Long id) {
        this.id = id;
    }

    public Agreement(Long id, String title, String appointId, String icon, java.util.Date date) {
        this.id = id;
        this.title = title;
        this.appointId = appointId;
        this.icon = icon;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

}
