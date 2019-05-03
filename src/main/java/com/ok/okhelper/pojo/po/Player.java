package com.ok.okhelper.pojo.po;

import javax.persistence.*;

public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "playerId")
    private String playerid;

    @Column(name = "playerTeam")
    private String playerteam;

    @Column(name = "playerRank")
    private Double playerrank;

    public Player(String id, String playerid, String playerteam, Double playerrank) {
        this.id = id;
        this.playerid = playerid;
        this.playerteam = playerteam;
        this.playerrank = playerrank;
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
     * @return playerRank
     */
    public Double getPlayerrank() {
        return playerrank;
    }

    /**
     * @param playerrank
     */
    public void setPlayerrank(Double playerrank) {
        this.playerrank = playerrank;
    }
}