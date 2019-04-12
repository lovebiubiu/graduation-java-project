package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class News {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    private String title;

    private String description;

    @Column(name = "picUrl")
    private String picurl;

    private String url;

    private String ctime;

    public News(String id, String title, String description, String picurl, String url, String ctime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picurl = picurl;
        this.url = url;
        this.ctime = ctime;
    }

    public News() {
        super();
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return picUrl
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * @param picurl
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return ctime
     */
    public String getCtime() {
        return ctime;
    }

    /**
     * @param ctime
     */
    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }
}