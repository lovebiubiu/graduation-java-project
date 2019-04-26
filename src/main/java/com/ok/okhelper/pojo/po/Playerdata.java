package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Playerdata {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "playerId")
    private String playerid;

    private String saiji;

    private String qiudui;

    private Integer changci;

    private Integer shoufa;

    private Double shijian;

    private String toulan;

    private String mingzhong1;

    private String sanfen;

    private String mingzhong2;

    private String faqiu;

    private String mingzhong3;

    private Double lanban;

    private Double zhugong;

    private Double qiangduan;

    private Double gaimao;

    private Double shiwu;

    private Double fangui;

    private Double defen;

    public Playerdata(String id, String playerid, String saiji, String qiudui, Integer changci, Integer shoufa, Double shijian, String toulan, String mingzhong1, String sanfen, String mingzhong2, String faqiu, String mingzhong3, Double lanban, Double zhugong, Double qiangduan, Double gaimao, Double shiwu, Double fangui, Double defen) {
        this.id = id;
        this.playerid = playerid;
        this.saiji = saiji;
        this.qiudui = qiudui;
        this.changci = changci;
        this.shoufa = shoufa;
        this.shijian = shijian;
        this.toulan = toulan;
        this.mingzhong1 = mingzhong1;
        this.sanfen = sanfen;
        this.mingzhong2 = mingzhong2;
        this.faqiu = faqiu;
        this.mingzhong3 = mingzhong3;
        this.lanban = lanban;
        this.zhugong = zhugong;
        this.qiangduan = qiangduan;
        this.gaimao = gaimao;
        this.shiwu = shiwu;
        this.fangui = fangui;
        this.defen = defen;
    }

    public Playerdata() {
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
     * @return playerId
     */
    public String getPlayerid() {
        return playerid;
    }

    /**
     * @param playerid
     */
    public void setPlayerid(String playerid) {
        this.playerid = playerid == null ? null : playerid.trim();
    }

    /**
     * @return saiji
     */
    public String getSaiji() {
        return saiji;
    }

    /**
     * @param saiji
     */
    public void setSaiji(String saiji) {
        this.saiji = saiji == null ? null : saiji.trim();
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

    /**
     * @return changci
     */
    public Integer getChangci() {
        return changci;
    }

    /**
     * @param changci
     */
    public void setChangci(Integer changci) {
        this.changci = changci;
    }

    /**
     * @return shoufa
     */
    public Integer getShoufa() {
        return shoufa;
    }

    /**
     * @param shoufa
     */
    public void setShoufa(Integer shoufa) {
        this.shoufa = shoufa;
    }

    /**
     * @return shijian
     */
    public Double getShijian() {
        return shijian;
    }

    /**
     * @param shijian
     */
    public void setShijian(Double shijian) {
        this.shijian = shijian;
    }

    /**
     * @return toulan
     */
    public String getToulan() {
        return toulan;
    }

    /**
     * @param toulan
     */
    public void setToulan(String toulan) {
        this.toulan = toulan == null ? null : toulan.trim();
    }

    /**
     * @return mingzhong1
     */
    public String getMingzhong1() {
        return mingzhong1;
    }

    /**
     * @param mingzhong1
     */
    public void setMingzhong1(String mingzhong1) {
        this.mingzhong1 = mingzhong1 == null ? null : mingzhong1.trim();
    }

    /**
     * @return sanfen
     */
    public String getSanfen() {
        return sanfen;
    }

    /**
     * @param sanfen
     */
    public void setSanfen(String sanfen) {
        this.sanfen = sanfen == null ? null : sanfen.trim();
    }

    /**
     * @return mingzhong2
     */
    public String getMingzhong2() {
        return mingzhong2;
    }

    /**
     * @param mingzhong2
     */
    public void setMingzhong2(String mingzhong2) {
        this.mingzhong2 = mingzhong2 == null ? null : mingzhong2.trim();
    }

    /**
     * @return faqiu
     */
    public String getFaqiu() {
        return faqiu;
    }

    /**
     * @param faqiu
     */
    public void setFaqiu(String faqiu) {
        this.faqiu = faqiu == null ? null : faqiu.trim();
    }

    /**
     * @return mingzhong3
     */
    public String getMingzhong3() {
        return mingzhong3;
    }

    /**
     * @param mingzhong3
     */
    public void setMingzhong3(String mingzhong3) {
        this.mingzhong3 = mingzhong3 == null ? null : mingzhong3.trim();
    }

    /**
     * @return lanban
     */
    public Double getLanban() {
        return lanban;
    }

    /**
     * @param lanban
     */
    public void setLanban(Double lanban) {
        this.lanban = lanban;
    }

    /**
     * @return zhugong
     */
    public Double getZhugong() {
        return zhugong;
    }

    /**
     * @param zhugong
     */
    public void setZhugong(Double zhugong) {
        this.zhugong = zhugong;
    }

    /**
     * @return qiangduan
     */
    public Double getQiangduan() {
        return qiangduan;
    }

    /**
     * @param qiangduan
     */
    public void setQiangduan(Double qiangduan) {
        this.qiangduan = qiangduan;
    }

    /**
     * @return gaimao
     */
    public Double getGaimao() {
        return gaimao;
    }

    /**
     * @param gaimao
     */
    public void setGaimao(Double gaimao) {
        this.gaimao = gaimao;
    }

    /**
     * @return shiwu
     */
    public Double getShiwu() {
        return shiwu;
    }

    /**
     * @param shiwu
     */
    public void setShiwu(Double shiwu) {
        this.shiwu = shiwu;
    }

    /**
     * @return fangui
     */
    public Double getFangui() {
        return fangui;
    }

    /**
     * @param fangui
     */
    public void setFangui(Double fangui) {
        this.fangui = fangui;
    }

    /**
     * @return defen
     */
    public Double getDefen() {
        return defen;
    }

    /**
     * @param defen
     */
    public void setDefen(Double defen) {
        this.defen = defen;
    }
}