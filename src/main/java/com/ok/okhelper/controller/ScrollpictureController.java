package com.ok.okhelper.controller;

import com.ok.okhelper.dao.ScrollpictureMapper;
import com.ok.okhelper.pojo.po.Scrollpicture;
import com.ok.okhelper.service.ScrollpictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "轮播图路由")
@RestController
public class ScrollpictureController {

    @Autowired
    ScrollpictureMapper scrollpictureMapper;
    @Autowired
    ScrollpictureService scrollpictureService;
    @ApiOperation(value = "查看轮播图",notes = "前端请求轮播图列表")
    @GetMapping("/selectScrollPicture")
    public List<Scrollpicture> selectScrollPicture(){
        List<Scrollpicture> list = scrollpictureMapper.selectList();
        return list;
    }

    @ApiOperation(value = "修改轮播图",notes = "后台请求修改轮播图")
    @PostMapping("/updateScrollPicture")
    public void updateScrollPicture(@RequestParam("id") String id,@RequestParam("pictureUrl") String pictureUrl,@RequestParam("pictureTitle") String pictureTitle,@RequestParam("newsUrl") String newsUrl){
        scrollpictureService.updateOne(id,pictureUrl,pictureTitle,newsUrl);
    }

    @ApiOperation(value = "添加轮播图",notes = "后台请求添加轮播图")
    @PostMapping("/insertScrollPicture")
    public void insertScrollPicture(@RequestParam("pictureUrl") String pictureUrl,@RequestParam("pictureTitle") String pictureTitle,@RequestParam("newsUrl") String newsUrl){
        scrollpictureService.insertOne(pictureUrl,pictureTitle,newsUrl);
    }

    @ApiOperation(value = "删除轮播图",notes = "后台请求删除轮播图")
    @PostMapping("/deleteScrollPicture")
    public void deleteScrollPicture(@RequestParam("id") String id){
        scrollpictureMapper.deleteOne(id);
    }
}
