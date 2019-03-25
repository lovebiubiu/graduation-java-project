package com.ok.okhelper.pojo.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "fighting_record")
public class FightingRecord {
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "run_away")
    private Boolean runAway;

    @Column(name = "open_id_winner")
    private String openIdWinner;

    @Column(name = "open_id_loser")
    private String openIdLoser;

    @Column(name = "score_winner")
    private Integer scoreWinner;

    @Column(name = "score_loser")
    private Integer scoreLoser;

    private Date time;

    public FightingRecord(Integer id, String roomName, Boolean runAway, String openIdWinner, String openIdLoser, Integer scoreWinner, Integer scoreLoser, Date time) {
        this.id = id;
        this.roomName = roomName;
        this.runAway = runAway;
        this.openIdWinner = openIdWinner;
        this.openIdLoser = openIdLoser;
        this.scoreWinner = scoreWinner;
        this.scoreLoser = scoreLoser;
        this.time = time;
    }

    public FightingRecord() {
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
     * @return room_name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    /**
     * @return run_away
     */
    public Boolean getRunAway() {
        return runAway;
    }

    /**
     * @param runAway
     */
    public void setRunAway(Boolean runAway) {
        this.runAway = runAway;
    }

    /**
     * @return open_id_winner
     */
    public String getOpenIdWinner() {
        return openIdWinner;
    }

    /**
     * @param openIdWinner
     */
    public void setOpenIdWinner(String openIdWinner) {
        this.openIdWinner = openIdWinner == null ? null : openIdWinner.trim();
    }

    /**
     * @return open_id_loser
     */
    public String getOpenIdLoser() {
        return openIdLoser;
    }

    /**
     * @param openIdLoser
     */
    public void setOpenIdLoser(String openIdLoser) {
        this.openIdLoser = openIdLoser == null ? null : openIdLoser.trim();
    }

    /**
     * @return score_winner
     */
    public Integer getScoreWinner() {
        return scoreWinner;
    }

    /**
     * @param scoreWinner
     */
    public void setScoreWinner(Integer scoreWinner) {
        this.scoreWinner = scoreWinner;
    }

    /**
     * @return score_loser
     */
    public Integer getScoreLoser() {
        return scoreLoser;
    }

    /**
     * @param scoreLoser
     */
    public void setScoreLoser(Integer scoreLoser) {
        this.scoreLoser = scoreLoser;
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