package com.ok.okhelper.service;

import com.ok.okhelper.pojo.po.News;

import java.util.List;

public interface NewsService {
    List<News> getNewsMessage(int pageNum);

    List<News> getNewsBackstage(int pageNum);

    void setVisible(String id);
}
