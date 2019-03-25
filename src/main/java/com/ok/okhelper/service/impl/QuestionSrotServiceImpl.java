package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.CsessioninfoMapper;
import com.ok.okhelper.dao.QuestionSortMapper;
import com.ok.okhelper.pojo.po.Csessioninfo;
import com.ok.okhelper.pojo.po.QuestionSort;
import com.ok.okhelper.service.QuestionSortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionSrotServiceImpl implements QuestionSortService {
    @Autowired
    QuestionSortMapper questionSortMapper;

    @Autowired
    CsessioninfoMapper csessioninfoMapper;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public List<QuestionSort> getRankTypeList() {
        List list = new ArrayList();
        list =questionSortMapper.getSortList();
        return list;
    }

    @Override
    public int getScore(String id) {
        int res;
        logger.info("------------------获取玩家分数-------------------");
        logger.info("玩家id---"+id);
        Csessioninfo user = csessioninfoMapper.getScore(id);

        if(user!=null){
            res=user.getScore();
        }else{
            res=-1;
        }
        return res;
    }

    @Override
    public List<Csessioninfo> getRankGlobalData() {
        List<Csessioninfo> list = new ArrayList<>();
        list = csessioninfoMapper.getRankGlobalData();
        return list;
    }

    @Override
    public List<Csessioninfo> getRankFriendsData() {
        List<Csessioninfo> list = new ArrayList<>();
        list = csessioninfoMapper.getRankGlobalData();
        return list;
    }

    @Override
    public String getGid(int openid) {
        String gid=null;
        Csessioninfo csessioninfo =csessioninfoMapper.getGid(openid);
        gid = csessioninfo.getSessionKey();
        return gid;
    }
}
