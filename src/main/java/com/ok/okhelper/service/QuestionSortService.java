package com.ok.okhelper.service;

import com.ok.okhelper.pojo.po.Csessioninfo;
import com.ok.okhelper.pojo.po.QuestionSort;

import java.util.List;

public interface QuestionSortService {

    List<QuestionSort> getRankTypeList();

    int getScore(String id,String name,String avatarUrl);

    List<Csessioninfo> getRankGlobalData(int globalPageNum);

    List<Csessioninfo> getRankFriendsData(String openId,int friendPagenum);

    String getGid(int openid);

    void updateUserScore(int win,String openId);
}
