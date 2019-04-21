package com.ok.okhelper.controller;

import com.ok.okhelper.pojo.po.Friendlylink;
import com.ok.okhelper.pojo.po.Schedule;
import com.ok.okhelper.service.FriendlyLinkService;
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

@Api(tags = "友情链接路由")
@RestController
public class FriendlyLinkController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FriendlyLinkService friendlyLinkService;

    @ApiOperation(value = "请求友情链接表",notes = "友情链接表")
    @GetMapping("/getFriendlyLinkList")
    public List<Friendlylink> getFriendlyLinkList(){
        logger.info("获取友链表");
        return friendlyLinkService.getFriendlyLinkList();
    }

    @ApiOperation(value = "插入友情链接",notes = "插入一个新的友情链接")
    @PostMapping("/insertFriendlyLink")
    public void insertFriendlyLink(@RequestParam("linkName") String linkName, @RequestParam("linkUrl") String linkUrl, @RequestParam("linkDescription") String linkDescription){
        logger.info("插入新的友链");
        friendlyLinkService.insertFriendlyLink(linkName,linkUrl,linkDescription);
    }

    @ApiOperation(value = "删除友情链接",notes = "删除一个友情链接")
    @PostMapping("/deleteFriendlyLink")
    public void deleteFriendlyLink(String id){
        logger.info("删除友链");
        friendlyLinkService.deleteFriendlyLink(id);
    }
}
