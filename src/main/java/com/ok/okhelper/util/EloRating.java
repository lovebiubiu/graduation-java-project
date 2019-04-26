package com.ok.okhelper.util;


import com.ok.okhelper.dao.EloscoreMapper;
import com.ok.okhelper.dao.TeamMapper;
import com.ok.okhelper.pojo.po.Eloscore;
import com.ok.okhelper.pojo.po.Team;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.lang.Math.pow;

/**
 *  2019/4/25
 *  create by xb
 *  ELO等级分系统
 *  初始分为1500
 *  因为是计算NBA球队胜率 整体水平较高 所以K值为32
 *  可调节为常规赛K为16 季后赛K为32
 * */
@Getter
@Setter
public class EloRating {
    @Autowired
    TeamMapper teamMapper;

    @Autowired
    EloscoreMapper eloscoreMapper;
    private double Rating_A = 0;
    private double Rating_B = 0;
    private double ELO_Default = 1500;
    private int ELO_Win = 1;    //胜利
    private int ELO_loss = -1;  //失败
    private int ELO_Draw = 0;   //平手

    public void init(){
        //初始化所有队伍分数为ELO_Default
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        teamMapper = act.getBean(TeamMapper.class);
        eloscoreMapper = act.getBean(EloscoreMapper.class);
        List<Team> list = teamMapper.selectAll();
        String id,teamId,chineseNickName;
        Eloscore eloscore;
        double rank;
        for(int i=0;i<list.size();i++){
            Team team = list.get(i);
            id = Long.toString(UidUtil.getInstance().nextId());
            teamId = team.getId();
            chineseNickName = team.getChinesenickname();
            rank = ELO_Default;
            eloscore = new Eloscore(id,chineseNickName,teamId,rank,0,0);
            eloscoreMapper.insert(eloscore);
        }
    }

    public int getK(double rating){
        if(rating>=2400){
            return 16;
        }else if(rating>=2100){
            return 24;
        }else {
            return 36;
        }
    }

    public void setResult(int res){
        double scoreA=getWinRating();
        double scoreB=1-scoreA;
        double score_adjust_A=0;
        double score_adjust_B=0;
        if(res == ELO_Win){
            score_adjust_A = 1;
            score_adjust_B = 0;
        }else if(res == ELO_loss){
            score_adjust_A = 0;
            score_adjust_B = 1;
        }else {
            score_adjust_A = 0.5;
            score_adjust_B = 0.5;
        }
        Rating_A = Rating_A + getK(Rating_A)*(score_adjust_A-scoreA);
        Rating_B = Rating_B + getK(Rating_B)*(score_adjust_B-scoreB);
    }

    public double getWinRating(){
        return 1/(1+pow(10,(Rating_B-Rating_A)/400));
    }

    public static void main(String[] args){
        EloRating eloRating = new EloRating();
        eloRating.setRating_A(1500);
        eloRating.setRating_B(1500);
        System.out.println("A的积分为:"+eloRating.getRating_A()+"|||B的积分为:"+eloRating.getRating_B());
        double winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));
        eloRating.setResult(-1);
        System.out.println("假设A失败");
        System.out.println("A的积分变化为:"+eloRating.getRating_A()+"|||B的积分变化为:"+eloRating.getRating_B());
        winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));
        eloRating.setResult(1);
        System.out.println("假设A胜利");
        System.out.println("A的积分变化为:"+eloRating.getRating_A()+"|||B的积分变化为:"+eloRating.getRating_B());
        winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));
        eloRating.setResult(1);
        System.out.println("假设A胜利");
        System.out.println("A的积分变化为:"+eloRating.getRating_A()+"|||B的积分变化为:"+eloRating.getRating_B());
        winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));
        eloRating.setResult(1);
        System.out.println("假设A胜利");
        System.out.println("A的积分变化为:"+eloRating.getRating_A()+"|||B的积分变化为:"+eloRating.getRating_B());
        winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));
        eloRating.setResult(1);
        System.out.println("假设A胜利");
        System.out.println("A的积分变化为:"+eloRating.getRating_A()+"|||B的积分变化为:"+eloRating.getRating_B());
        winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));
        eloRating.setResult(1);
        System.out.println("假设A胜利");
        System.out.println("A的积分变化为:"+eloRating.getRating_A()+"|||B的积分变化为:"+eloRating.getRating_B());
        winrate = eloRating.getWinRating();
        System.out.println("A的胜率为:"+winrate+"|||B的胜率为:"+(1-winrate));

    }
}
