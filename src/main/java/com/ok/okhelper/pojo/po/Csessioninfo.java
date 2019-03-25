package com.ok.okhelper.pojo.po;

import java.util.Date;
import javax.persistence.*;

public class Csessioninfo {
    @Column(name = "open_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String openId;

    private String uuid;

    private String skey;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_visit_time")
    private Date lastVisitTime;

    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "user_info")
    private String userInfo;

    private Integer score;

    public Csessioninfo(String openId, String uuid, String skey, Date createTime, Date lastVisitTime, String sessionKey, String userInfo, Integer score) {
        this.openId = openId;
        this.uuid = uuid;
        this.skey = skey;
        this.createTime = createTime;
        this.lastVisitTime = lastVisitTime;
        this.sessionKey = sessionKey;
        this.userInfo = userInfo;
        this.score = score;
    }

    public Csessioninfo() {
        super();
    }

    /**
     * @return open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * @return skey
     */
    public String getSkey() {
        return skey;
    }

    /**
     * @param skey
     */
    public void setSkey(String skey) {
        this.skey = skey == null ? null : skey.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return last_visit_time
     */
    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    /**
     * @param lastVisitTime
     */
    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    /**
     * @return session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    /**
     * @return user_info
     */
    public String getUserInfo() {
        return userInfo;
    }

    /**
     * @param userInfo
     */
    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    /**
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}