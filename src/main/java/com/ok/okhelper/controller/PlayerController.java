package com.ok.okhelper.controller;

import com.ok.okhelper.dao.EloscoreMapper;
import com.ok.okhelper.dao.PlayerMapper;
import com.ok.okhelper.dao.PlayerdataMapper;
import com.ok.okhelper.pojo.po.*;
import com.ok.okhelper.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "球员路由")
@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @Autowired
    PlayerdataMapper playerdataMapper;
    @Autowired
    PlayerMapper playerMapper;

    @ApiOperation(value = "请求球员列表",notes = "获取球员列表")
    @GetMapping("/getPlayerList")
    public List<Playerdata> getPlayerList(int pageNum){
        return playerdataMapper.selectList(pageNum*9);
    }
    @ApiOperation(value = "请求球员列表总数",notes = "请求球员列表总数")
    @GetMapping("/getAllLength")
    public int getAllLength(){
        return playerdataMapper.selectLength().size();
    }
    @ApiOperation(value = "请求球员战力值排名",notes = "请求球员战力值排名列表")
    @GetMapping("/getPlayerRankList")
    public List<player_playerInfo> getPlayerRankList(){
        return playerMapper.selectRankList();
    }

    @ApiOperation(value = "刷新战力评分",notes = "刷新球员战力评分")
    @GetMapping("/initPlayerRank")
    public void InitPlayerRank(){
        playerService.initPlayerList();
    }
}
