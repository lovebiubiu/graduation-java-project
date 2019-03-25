package com.ok.okhelper.controller;

import com.ok.okhelper.pojo.po.Csessioninfo;
import com.ok.okhelper.pojo.po.QuestionSort;
import com.ok.okhelper.service.QuestionSortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "业务路由")
@RestController
public class QuestionSortController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuestionSortService questionSortService;

    @ApiOperation(value = "获取群ID",notes = "获取分享群ID")
    @GetMapping("/getGid")
    public String getGid(int openid){

        return questionSortService.getGid(openid);
    }
    @ApiOperation(value = "请求得分数",notes = "根据openid查询得分")
    @GetMapping("/getScore")
    public int getScore(String openid){
        logger.info("controller ID = "+openid);
        return questionSortService.getScore(openid);
    }
    @ApiOperation(value = "请求二维码",notes = "请求二维码图片地址")
    @GetMapping("/qrAddress")
    public String qrAddress(){

        return "";
    }
    @ApiOperation(value = "请求分类",notes = "请求题目分类")
    @GetMapping("/getRankType")
    public List<QuestionSort> getRankType(){
        List<QuestionSort> list = new ArrayList<>();
        list = questionSortService.getRankTypeList();
        return list;
    }

    @ApiOperation(value = "存储用户分享后的信息",notes = "存储用户分享后的信息")
    @GetMapping("/storeFriendsNetwork")
    public String storeFriendsNetwork(){

        return "";
    }
    @ApiOperation(value = "获取好友排行榜",notes = "获取好友用户关系表")
    @GetMapping("/getRankFriendsData")
    public List<Csessioninfo> getRankFriendsData(){

        return questionSortService.getRankFriendsData();
    }
    @ApiOperation(value = "获取全球排行榜",notes = "获取全球用户关系表(排行榜)")
    @GetMapping("/getRankGlobalData")
    public List<Csessioninfo> getRankGlobalData(){

        return questionSortService.getRankGlobalData();
    }
    @ApiOperation(value = "存储用户关系点击表",notes = "存储用户关系点击表")
    @GetMapping("/storeUserNetwork")
    public int storeUserNetwork(){
        int score=1;
        return score;
    }

    @ApiOperation(value = "更新用户关系点击表中的fromClickId",notes = "更新用户关系点击表中的fromClickId")
    @GetMapping("/updateUserNetworkFromClickId")
    public int updateUserNetworkFromClickId(){
        int score=1;
        return score;
    }

    @ApiOperation(value = "更新用户关系点击表中的fromClickId",notes = "更新用户关系点击表中的fromClickId")
    @GetMapping("/updateShareInfoToUserNetwork")
    public int updateShareInfoToUserNetwork(){
        int score=1;
        return score;
    }
}
