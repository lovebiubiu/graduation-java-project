package com.ok.okhelper.controller;

import com.ok.okhelper.dao.EloscoreMapper;
import com.ok.okhelper.dao.PlayerdataMapper;
import com.ok.okhelper.pojo.po.News;
import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.PlayerRankList;
import com.ok.okhelper.pojo.po.Playerdata;
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
    @ApiOperation(value = "请求球员列表",notes = "获取球员列表")
    @GetMapping("/getPlayerList")
    public List<Player> getPlayerList(){
        return playerService.getPlayerList();
    }

    @ApiOperation(value = "请求球员战力值列表",notes = "请求球员战力值列表")
    @GetMapping("/getPlayerEloList")
    public List<PlayerRankList> getPlayerEloList(){
        return playerdataMapper.selectRankList();
    }
}
