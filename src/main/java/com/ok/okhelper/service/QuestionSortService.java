package com.ok.okhelper.service;

import com.ok.okhelper.pojo.po.Csessioninfo;
import com.ok.okhelper.pojo.po.QuestionSort;

import java.util.List;

public interface QuestionSortService {

    List<QuestionSort> getRankTypeList();

    int getScore(String id);

    List<Csessioninfo> getRankGlobalData();

    List<Csessioninfo> getRankFriendsData();

    String getGid(int openid);
}
