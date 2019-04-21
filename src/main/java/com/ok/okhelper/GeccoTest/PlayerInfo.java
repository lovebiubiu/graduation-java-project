package com.ok.okhelper.GeccoTest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class PlayerInfo {
    private String playerName;
    private String playerTeam;
    private double playerScore;
    private double hit;
    private double shotNum;
    private String hitRate;
    private double threePointHit;
    private double threePointShotNum;
    private String threePointHitRate;
    private double penaltyShotHit;
    private double penaltyShotHitNum;
    private String penaltyShotHitRate;
    private double contestNum;
    private double contestTime;

    public PlayerInfo(String playerName,String playerTeam,double playerScore,double hit,double shotNum,String hitRate,double threePointHit,double threePointShotNum,String threePointHitRate,double penaltyShotHit,double penaltyShotHitNum,String penaltyShotHitRate,double contestNum,double contestTime){
        this.playerName = playerName;
        this.playerTeam = playerTeam;
        this.playerScore = playerScore;
        this.hit = hit;
        this.shotNum = shotNum;
        this.hitRate = hitRate;
        this.threePointHit = threePointHit;
        this.threePointShotNum = threePointShotNum;
        this.threePointHitRate = threePointHitRate;
        this.penaltyShotHit = penaltyShotHit;
        this.penaltyShotHitNum = penaltyShotHitNum;
        this.penaltyShotHitRate = penaltyShotHitRate;
        this.contestNum = contestNum;
        this.contestTime = contestTime;
    }
}
