package com.ok.okhelper.controller;

import com.ok.okhelper.pojo.po.News;
import com.ok.okhelper.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "新闻相关")
@RestController
public class NewsController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NewsService newsService;
    @ApiOperation(value = "请求新闻",notes = "根据页码请求新闻")
    @GetMapping("/getNews")
    public List<News> getNews(int pageNum){
        return newsService.getNewsMessage(pageNum);
    }
}
