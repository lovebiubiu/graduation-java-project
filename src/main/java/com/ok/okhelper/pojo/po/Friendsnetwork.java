package com.ok.okhelper.pojo.po;

import java.util.Date;
import javax.persistence.*;

public class Friendsnetwork {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "openId")
    private String openid;

    @Column(name = "appId")
    private String appid;

    @Column(name = "fromOpenId")
    private String fromopenid;

    @Column(name = "fromGId")
    private String fromgid;

    private Date time;

    public Friendsnetwork(Integer id, String openid, String appid, String fromopenid, String fromgid, Date time) {
        this.id = id;
        this.openid = openid;
        this.appid = appid;
        this.fromopenid = fromopenid;
        this.fromgid = fromgid;
        this.time = time;
    }

    public Friendsnetwork() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return openId
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * @return appId
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * @return fromOpenId
     */
    public String getFromopenid() {
        return fromopenid;
    }

    /**
     * @param fromopenid
     */
    public void setFromopenid(String fromopenid) {
        this.fromopenid = fromopenid == null ? null : fromopenid.trim();
    }

    /**
     * @return fromGId
     */
    public String getFromgid() {
        return fromgid;
    }

    /**
     * @param fromgid
     */
    public void setFromgid(String fromgid) {
        this.fromgid = fromgid == null ? null : fromgid.trim();
    }

    /**
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }
}