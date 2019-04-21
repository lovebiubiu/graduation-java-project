package com.ok.okhelper.service.impl;

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
    }
    public static void main(String[] args) throws IOException {

    }
}
