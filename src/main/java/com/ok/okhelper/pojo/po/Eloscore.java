package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Eloscore {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "chineseNickName")
    private String chinesenickname;

    @Column(name = "teamId")
    private String teamid;

    private Double rank;

    private Integer win;

    private Integer lose;

    public Eloscore(String id, String chinesenickname, String teamid, Double rank, Integer win, Integer lose) {
        this.id = id;
        this.chinesenickname = chinesenickname;
        this.teamid = teamid;
        this.rank = rank;
        this.win = win;
        this.lose = lose;
    }

    public Eloscore() {
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
     * @return teamId
     */
    public String getTeamid() {
        return teamid;
    }

    /**
     * @param teamid
     */
    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    /**
     * @return rank
     */
    public Double getRank() {
        return rank;
    }

    /**
     * @param rank
     */
    public void setRank(Double rank) {
        this.rank = rank;
    }

    /**
     * @return win
     */
    public Integer getWin() {
        return win;
    }

    /**
     * @param win
     */
    public void setWin(Integer win) {
        this.win = win;
    }

    /**
     * @return lose
     */
    public Integer getLose() {
        return lose;
    }

    /**
     * @param lose
     */
    public void setLose(Integer lose) {
        this.lose = lose;
    }
}