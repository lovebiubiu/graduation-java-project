package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.News;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "NewsMapper")
public interface NewsMapper extends MyMapper<News> {
    void insertNews(News news);

    void deleteNews();

    List<News> getNewsData(int pageNum);
}