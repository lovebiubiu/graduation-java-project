package com.ok.okhelper.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_network")
public class UserNetwork {
    @Column(name = "clickId")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer clickid;

    @Column(name = "fromClickId")
    private Integer fromclickid;

    private String appid;

    private String openid;

    @Column(name = "fromGId")
    private String fromgid;

    private Integer scene;

    private Date time;

    @Column(name = "param_1")
    private String param1;

    public UserNetwork(Integer clickid, Integer fromclickid, String appid, String openid, String fromgid, Integer scene, Date time, String param1) {
        this.clickid = clickid;
        this.fromclickid = fromclickid;
        this.appid = appid;
        this.openid = openid;
        this.fromgid = fromgid;
        this.scene = scene;
        this.time = time;
        this.param1 = param1;
    }

    public UserNetwork() {
        super();
    }

    /**
     * @return clickId
     */
    public Integer getClickid() {
        return clickid;
    }

    /**
     * @param clickid
     */
    public void setClickid(Integer clickid) {
        this.clickid = clickid;
    }

    /**
     * @return fromClickId
     */
    public Integer getFromclickid() {
        return fromclickid;
    }

    /**
     * @param fromclickid
     */
    public void setFromclickid(Integer fromclickid) {
        this.fromclickid = fromclickid;
    }

    /**
     * @return appid
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
     * @return openid
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
     * @return scene
     */
    public Integer getScene() {
        return scene;
    }

    /**
     * @param scene
     */
    public void setScene(Integer scene) {
        this.scene = scene;
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

    /**
     * @return param_1
     */
    public String getParam1() {
        return param1;
    }

    /**
     * @param param1
     */
    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }
}