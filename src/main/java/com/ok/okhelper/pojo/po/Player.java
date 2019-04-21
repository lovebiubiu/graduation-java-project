package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "playerName")
    private String playername;

    @Column(name = "playerTeam")
    private String playerteam;

    @Column(name = "playerScore")
    private Double playerscore;

    private Double hit;

    @Column(name = "shotNum")
    private Double shotnum;

    @Column(name = "hitRate")
    private String hitrate;

    @Column(name = "threePointHit")
    private Double threepointhit;

    @Column(name = "threePointShotNum")
    private Double threepointshotnum;

    @Column(name = "threePointHitRate")
    private String threepointhitrate;

    @Column(name = "penaltyShotHit")
    private Double penaltyshothit;

    @Column(name = "penaltyShotHitNum")
    private Double penaltyshothitnum;

    @Column(name = "penaltyShotHitRate")
    private String penaltyshothitrate;

    @Column(name = "contestNum")
    private Double contestnum;

    @Column(name = "contestTime")
    private Double contesttime;

    public Player(String id, String playername, String playerteam, Double playerscore, Double hit, Double shotnum, String hitrate, Double threepointhit, Double threepointshotnum, String threepointhitrate, Double penaltyshothit, Double penaltyshothitnum, String penaltyshothitrate, Double contestnum, Double contesttime) {
        this.id = id;
        this.playername = playername;
        this.playerteam = playerteam;
        this.playerscore = playerscore;
        this.hit = hit;
        this.shotnum = shotnum;
        this.hitrate = hitrate;
        this.threepointhit = threepointhit;
        this.threepointshotnum = threepointshotnum;
        this.threepointhitrate = threepointhitrate;
        this.penaltyshothit = penaltyshothit;
        this.penaltyshothitnum = penaltyshothitnum;
        this.penaltyshothitrate = penaltyshothitrate;
        this.contestnum = contestnum;
        this.contesttime = contesttime;
    }

    public Player() {
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
     * @return playerTeam
     */
    public String getPlayerteam() {
        return playerteam;
    }

    /**
     * @param playerteam
     */
    public void setPlayerteam(String playerteam) {
        this.playerteam = playerteam == null ? null : playerteam.trim();
    }

    /**
     * @return playerScore
     */
    public Double getPlayerscore() {
        return playerscore;
    }

    /**
     * @param playerscore
     */
    public void setPlayerscore(Double playerscore) {
        this.playerscore = playerscore;
    }

    /**
     * @return hit
     */
    public Double getHit() {
        return hit;
    }

    /**
     * @param hit
     */
    public void setHit(Double hit) {
        this.hit = hit;
    }

    /**
     * @return shotNum
     */
    public Double getShotnum() {
        return shotnum;
    }

    /**
     * @param shotnum
     */
    public void setShotnum(Double shotnum) {
        this.shotnum = shotnum;
    }

    /**
     * @return hitRate
     */
    public String getHitrate() {
        return hitrate;
    }

    /**
     * @param hitrate
     */
    public void setHitrate(String hitrate) {
        this.hitrate = hitrate == null ? null : hitrate.trim();
    }

    /**
     * @return threePointHit
     */
    public Double getThreepointhit() {
        return threepointhit;
    }

    /**
     * @param threepointhit
     */
    public void setThreepointhit(Double threepointhit) {
        this.threepointhit = threepointhit;
    }

    /**
     * @return threePointShotNum
     */
    public Double getThreepointshotnum() {
        return threepointshotnum;
    }

    /**
     * @param threepointshotnum
     */
    public void setThreepointshotnum(Double threepointshotnum) {
        this.threepointshotnum = threepointshotnum;
    }

    /**
     * @return threePointHitRate
     */
    public String getThreepointhitrate() {
        return threepointhitrate;
    }

    /**
     * @param threepointhitrate
     */
    public void setThreepointhitrate(String threepointhitrate) {
        this.threepointhitrate = threepointhitrate == null ? null : threepointhitrate.trim();
    }

    /**
     * @return penaltyShotHit
     */
    public Double getPenaltyshothit() {
        return penaltyshothit;
    }

    /**
     * @param penaltyshothit
     */
    public void setPenaltyshothit(Double penaltyshothit) {
        this.penaltyshothit = penaltyshothit;
    }

    /**
     * @return penaltyShotHitNum
     */
    public Double getPenaltyshothitnum() {
        return penaltyshothitnum;
    }

    /**
     * @param penaltyshothitnum
     */
    public void setPenaltyshothitnum(Double penaltyshothitnum) {
        this.penaltyshothitnum = penaltyshothitnum;
    }

    /**
     * @return penaltyShotHitRate
     */
    public String getPenaltyshothitrate() {
        return penaltyshothitrate;
    }

    /**
     * @param penaltyshothitrate
     */
    public void setPenaltyshothitrate(String penaltyshothitrate) {
        this.penaltyshothitrate = penaltyshothitrate == null ? null : penaltyshothitrate.trim();
    }

    /**
     * @return contestNum
     */
    public Double getContestnum() {
        return contestnum;
    }

    /**
     * @param contestnum
     */
    public void setContestnum(Double contestnum) {
        this.contestnum = contestnum;
    }

    /**
     * @return contestTime
     */
    public Double getContesttime() {
        return contesttime;
    }

    /**
     * @param contesttime
     */
    public void setContesttime(Double contesttime) {
        this.contesttime = contesttime;
    }
}