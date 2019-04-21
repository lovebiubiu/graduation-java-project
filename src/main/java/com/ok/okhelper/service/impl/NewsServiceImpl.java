package com.ok.okhelper.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ok.okhelper.dao.NewsMapper;
import com.ok.okhelper.pojo.po.News;
import com.ok.okhelper.service.NewsService;
import com.ok.okhelper.util.ApplicationContextRegister;
import com.ok.okhelper.util.HttpClient;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component

//@Getter
//@Setter
//@EnableScheduling
//@Configuration
@Service
public class NewsServiceImpl implements NewsService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NewsMapper newsMapper;

    static String url = "http://api.tianapi.com/nba/?key=345fd9f07e15937b2ff3559bd8e7a92c&num=49";

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    //@Scheduled(cron = "* * * * * * ")
    public void NewsSchedulePlan() {
        logger.info("调用定时新闻");
        String res = HttpClient.doPost(url,"GET");
        JSONObject jsonObject = JSONObject.parseObject(res);
        if(jsonObject.getString("code").equals("200")){
            ApplicationContext act = ApplicationContextRegister.getApplicationContext();
            newsMapper = act.getBean(NewsMapper.class);
            newsMapper.deleteNews();
            String res2 = jsonObject.getString("newslist");
            JSONArray jsonArray = JSONArray.parseArray(res2);
            for(int i = 0 ;i<jsonArray.size();i++){
                JSONObject temp = jsonArray.getJSONObject(i);
                News newstemp = new News(Long.toString(UidUtil.getInstance().nextId()),temp.getString("title"),temp.getString("description"),temp.getString("picUrl"),temp.getString("url"),temp.getString("ctime"));
                newsMapper.insertNews(newstemp);
            }
        }

    }

    @Override
    public List<News> getNewsMessage(int pageNum) {
        List<News> list = newsMapper.getNewsData(pageNum*10);
        return list;
    }

}
