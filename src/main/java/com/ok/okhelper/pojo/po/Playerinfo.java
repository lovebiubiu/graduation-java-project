package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Playerinfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "playerName")
    private String playername;

    @Column(name = "chineseName")
    private String chinesename;

    @Column(name = "avatarUrl")
    private String avatarurl;

    private String weizhi;

    private String shengao;

    private String tizhong;

    private String shengri;

    private String qiudui;

    public Playerinfo(String id, String playername, String chinesename, String avatarurl, String weizhi, String shengao, String tizhong, String shengri, String qiudui) {
        this.id = id;
        this.playername = playername;
        this.chinesename = chinesename;
        this.avatarurl = avatarurl;
        this.weizhi = weizhi;
        this.shengao = shengao;
        this.tizhong = tizhong;
        this.shengri = shengri;
        this.qiudui = qiudui;
    }

    public Playerinfo() {
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
     * @return playerName
     */
    public String getPlayername() {
        return playername;
    }

    /**
     * @param playername
     */
    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }

    /**
     * @return chineseName
     */
    public String getChinesename() {
        return chinesename;
    }

    /**
     * @param chinesename
     */
    public void setChinesename(String chinesename) {
        this.chinesename = chinesename == null ? null : chinesename.trim();
    }

    /**
     * @return avatarUrl
     */
    public String getAvatarurl() {
        return avatarurl;
    }

    /**
     * @param avatarurl
     */
    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    /**
     * @return weizhi
     */
    public String getWeizhi() {
        return weizhi;
    }

    /**
     * @param weizhi
     */
    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi == null ? null : weizhi.trim();
    }

    /**
     * @return shengao
     */
    public String getShengao() {
        return shengao;
    }

    /**
     * @param shengao
     */
    public void setShengao(String shengao) {
        this.shengao = shengao == null ? null : shengao.trim();
    }

    /**
     * @return tizhong
     */
    public String getTizhong() {
        return tizhong;
    }

    /**
     * @param tizhong
     */
    public void setTizhong(String tizhong) {
        this.tizhong = tizhong == null ? null : tizhong.trim();
    }

    /**
     * @return shengri
     */
    public String getShengri() {
        return shengri;
    }

    /**
     * @param shengri
     */
    public void setShengri(String shengri) {
        this.shengri = shengri == null ? null : shengri.trim();
    }

    /**
     * @return qiudui
     */
    public String getQiudui() {
        return qiudui;
    }

    /**
     * @param qiudui
     */
    public void setQiudui(String qiudui) {
        this.qiudui = qiudui == null ? null : qiudui.trim();
    }
}