package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Team {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "nickName")
    private String nickname;

    @Column(name = "teamName")
    private String teamname;

    @Column(name = "chineseName")
    private String chinesename;

    @Column(name = "chineseNickName")
    private String chinesenickname;

    @Column(name = "enterNBA")
    private String enternba;

    @Column(name = "mainPlace")
    private String mainplace;

    private String webstation;

    private String coach;

    private String description;

    public Team(String id, String nickname, String teamname, String chinesename, String chinesenickname, String enternba, String mainplace, String webstation, String coach, String description) {
        this.id = id;
        this.nickname = nickname;
        this.teamname = teamname;
        this.chinesename = chinesename;
        this.chinesenickname = chinesenickname;
        this.enternba = enternba;
        this.mainplace = mainplace;
        this.webstation = webstation;
        this.coach = coach;
        this.description = description;
    }

    public Team() {
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
     * @return nickName
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * @return teamName
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * @param teamname
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
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
     * @return chineseNickName
     */
    public String getChinesenickname() {
        return chinesenickname;
    }

    /**
     * @param chinesenickname
     */
    public void setChinesenickname(String chinesenickname) {
        this.chinesenickname = chinesenickname == null ? null : chinesenickname.trim();
    }

    /**
     * @return enterNBA
     */
    public String getEnternba() {
        return enternba;
    }

    /**
     * @param enternba
     */
    public void setEnternba(String enternba) {
        this.enternba = enternba == null ? null : enternba.trim();
    }

    /**
     * @return mainPlace
     */
    public String getMainplace() {
        return mainplace;
    }

    /**
     * @param mainplace
     */
    public void setMainplace(String mainplace) {
        this.mainplace = mainplace == null ? null : mainplace.trim();
    }

    /**
     * @return webstation
     */
    public String getWebstation() {
        return webstation;
    }

    /**
     * @param webstation
     */
    public void setWebstation(String webstation) {
        this.webstation = webstation == null ? null : webstation.trim();
    }

    /**
     * @return coach
     */
    public String getCoach() {
        return coach;
    }

    /**
     * @param coach
     */
    public void setCoach(String coach) {
        this.coach = coach == null ? null : coach.trim();
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
}