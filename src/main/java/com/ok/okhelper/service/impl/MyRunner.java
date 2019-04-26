package com.ok.okhelper.service.impl;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.ok.okhelper.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class MyRunner implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NewsService newsService;
    @Override
    public void run(String... args) throws Exception {
        log.info("———————————————执行启动方法———————————————");
//        NewsServiceImpl newsService = new NewsServiceImpl();
//        newsService.NewsSchedulePlan();

//        HttpGetRequest startUrl = new HttpGetRequest("https://nba.hupu.com/teams");
//        startUrl.setCharset("GBK");
//        GeccoEngine.create()
//                //Gecco搜索的包路径
//                .classpath("com.ok.okhelper.GeccoTest")
//                //开始抓取的页面地址
//                .start(startUrl)
//                //开启几个爬虫线程
//                .thread(10)
//                //单个爬虫每次抓取完一个请求后的间隔时间
//                .interval(2000)
//                .run();

    }
    public static void main(String[] args) throws IOException {

    }
}
