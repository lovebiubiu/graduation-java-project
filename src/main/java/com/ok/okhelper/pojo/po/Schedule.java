package com.ok.okhelper.pojo.po;

import java.util.Date;
import javax.persistence.*;

public class Schedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    private String title;

    private String player1;

    @Column(name = "player1_logo")
    private String player1Logo;

    @Column(name = "player1_logo_big")
    private String player1LogoBig;

    @Column(name = "player1_Url")
    private String player1Url;

    private String player2;

    @Column(name = "player2_logo")
    private String player2Logo;

    @Column(name = "player2_logo_big")
    private String player2LogoBig;

    @Column(name = "player2_Url")
    private String player2Url;

    private String score;

    private String status;

    private String time;

    public Schedule(String id, String title, String player1, String player1Logo, String player1LogoBig, String player1Url, String player2, String player2Logo, String player2LogoBig, String player2Url, String score, String status, String time) {
        this.id = id;
        this.title = title;
        this.player1 = player1;
        this.player1Logo = player1Logo;
        this.player1LogoBig = player1LogoBig;
        this.player1Url = player1Url;
        this.player2 = player2;
        this.player2Logo = player2Logo;
        this.player2LogoBig = player2LogoBig;
        this.player2Url = player2Url;
        this.score = score;
        this.status = status;
        this.time = time;
    }

    public Schedule() {
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
        this.title = title;
    }

    /**
     * @return player1
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * @param player1
     */
    public void setPlayer1(String player1) {
        this.player1 = player1 == null ? null : player1.trim();
    }

    /**
     * @return player1_logo
     */
    public String getPlayer1Logo() {
        return player1Logo;
    }

    /**
     * @param player1Logo
     */
    public void setPlayer1Logo(String player1Logo) {
        this.player1Logo = player1Logo == null ? null : player1Logo.trim();
    }

    /**
     * @return player1_logo_big
     */
    public String getPlayer1LogoBig() {
        return player1LogoBig;
    }

    /**
     * @param player1LogoBig
     */
    public void setPlayer1LogoBig(String player1LogoBig) {
        this.player1LogoBig = player1LogoBig == null ? null : player1LogoBig.trim();
    }

    /**
     * @return player1_Url
     */
    public String getPlayer1Url() {
        return player1Url;
    }

    /**
     * @param player1Url
     */
    public void setPlayer1Url(String player1Url) {
        this.player1Url = player1Url == null ? null : player1Url.trim();
    }

    /**
     * @return player2
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * @param player2
     */
    public void setPlayer2(String player2) {
        this.player2 = player2 == null ? null : player2.trim();
    }

    /**
     * @return player2_logo
     */
    public String getPlayer2Logo() {
        return player2Logo;
    }

    /**
     * @param player2Logo
     */
    public void setPlayer2Logo(String player2Logo) {
        this.player2Logo = player2Logo == null ? null : player2Logo.trim();
    }

    /**
     * @return player2_logo_big
     */
    public String getPlayer2LogoBig() {
        return player2LogoBig;
    }

    /**
     * @param player2LogoBig
     */
    public void setPlayer2LogoBig(String player2LogoBig) {
        this.player2LogoBig = player2LogoBig == null ? null : player2LogoBig.trim();
    }

    /**
     * @return player2_Url
     */
    public String getPlayer2Url() {
        return player2Url;
    }

    /**
     * @param player2Url
     */
    public void setPlayer2Url(String player2Url) {
        this.player2Url = player2Url == null ? null : player2Url.trim();
    }

    /**
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }
}