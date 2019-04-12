package com.ok.okhelper.service.impl;

import com.ok.okhelper.pojo.po.News;
import com.ok.okhelper.util.GetAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Order(1)
public class MyRunner implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void run(String... args) throws Exception {
        log.info("———————————————执行启动方法,获取新闻———————————————");
        NewsServiceImpl newsService = new NewsServiceImpl();
//        List<News> list = newsService.getNewsMessage();
//        System.out.println(list);
//        String requestUrl= GetAccessToken.url+"?grant_type="+GetAccessToken.grantType+"&appid="+GetAccessToken.appid+"&secret="+GetAccessToken.secret;
//        GetAccessToken.AccessToken=GetAccessToken.doPost(requestUrl,"");
        //log.info("AccessToken:"+GetAccessToken.AccessToken);
        //GetAccessToken.getQr();
    }
    public static void main(String[] args) throws IOException {
        System.out.println("------------AccessToken:"+GetAccessToken.AccessToken+"-------------------");
        String requestUrl= GetAccessToken.url+"?grant_type="+GetAccessToken.grantType+"&appid="+GetAccessToken.appid+"&secret="+GetAccessToken.secret;
        GetAccessToken.AccessToken=GetAccessToken.doPost(requestUrl,"");
        GetAccessToken.getQr__2("qaq");
    }
}
