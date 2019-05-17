package com.ok.okhelper.controller;

import com.ok.okhelper.dao.EloscoreMapper;
import com.ok.okhelper.dao.TeamMapper;
import com.ok.okhelper.pojo.po.Eloscore;
import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.ScheduleForecast;
import com.ok.okhelper.pojo.po.Team;
import com.ok.okhelper.service.ScheduleService;
import com.ok.okhelper.util.EloRating;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "球队路由")
@RestController
public class TeamController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    EloscoreMapper eloscoreMapper;

    @Autowired
    ScheduleService scheduleService;

    @ApiOperation(value = "请求球队列表",notes = "后台请求球队列表")
    @GetMapping("/getTeamList")
    public List<Eloscore> getPlayerList(){
        return eloscoreMapper.selectAll();
    }

    @ApiOperation(value = "请求球队列表",notes = "前台请求球队列表")
    @GetMapping("/getAllList")
    public List<Team> getAllList(){
        return teamMapper.selectAll();
    }


    @ApiOperation(value = "请求球队势力值列表",notes = "前台请求势力值列表")
    @GetMapping("/getTeamRankList")
    public List<Eloscore> getTeamRankList(){
        return eloscoreMapper.selectRankList();
    }

    @ApiOperation(value = "请求比赛势力值及胜率",notes = "请求比赛势力值及胜率")
    @GetMapping("/getEloscoreandRate")
    public List<ScheduleForecast> getEloscoreandRate(String team1,String team2){
        return scheduleService.getForecast(team1,team2);
    }

    @ApiOperation(value = "录入一场结果",notes = "请求录入一场球赛结果，默认team1胜利 team2失败")
    @PostMapping("/updateEloScore")
    public void 请求录入一场球赛结果(@RequestParam("team1") String team1, @RequestParam("team2") String team2){
        EloRating eloRating = new EloRating();
        double rank1,rank2;
        rank1 = eloscoreMapper.selectRankOne(team1);
        rank2 = eloscoreMapper.selectRankOne(team2);
        eloRating.setRating_A(rank1);
        eloRating.setRating_B(rank2);
        eloRating.setResult(1);
        rank1 = eloRating.getRating_A();
        rank2 = eloRating.getRating_B();
        eloscoreMapper.updateRankOne(team1,rank1);
        eloscoreMapper.updateRankOne(team2,rank2);
    }
}
