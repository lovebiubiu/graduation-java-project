package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Scrollpicture {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "picture_title")
    private String pictureTitle;

    @Column(name = "news_url")
    private String newsUrl;

    public Scrollpicture(String id, String pictureUrl, String pictureTitle, String newsUrl) {
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.pictureTitle = pictureTitle;
        this.newsUrl = newsUrl;
    }

    public Scrollpicture() {
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
     * @return picture_url
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * @param pictureUrl
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    /**
     * @return picture_title
     */
    public String getPictureTitle() {
        return pictureTitle;
    }

    /**
     * @param pictureTitle
     */
    public void setPictureTitle(String pictureTitle) {
        this.pictureTitle = pictureTitle == null ? null : pictureTitle.trim();
    }

    /**
     * @return news_url
     */
    public String getNewsUrl() {
        return newsUrl;
    }

    /**
     * @param newsUrl
     */
    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl == null ? null : newsUrl.trim();
    }
}