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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int getScore(String id,String name,String avatarUrl) {
        int res;
        logger.info("------------------获取玩家分数-------------------");
        Csessioninfo user = csessioninfoMapper.getScore(id);

        if(user!=null){
            res=user.getScore();
        }else{
            createNewUser(id,name,avatarUrl);
            res = 0;
        }
        return res;
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void createNewUser(String openId,String userName,String avatarUrl){
        Csessioninfo user = new Csessioninfo(openId,"","",new Date(),new Date(),"",userName,0,avatarUrl);
        csessioninfoMapper.insertUser(user);
    }

    @Override
    public List<Csessioninfo> getRankGlobalData(int globalPageNum) {
        List<Csessioninfo> list = new ArrayList<>();
        int num = globalPageNum*10;
        list = csessioninfoMapper.getRankGlobalData(num);

        return list;
    }

    @Override
    public List<Csessioninfo> getRankFriendsData(String openId,int friendPagenum) {

        return csessioninfoMapper.getRankFriendsData(openId,friendPagenum);
    }


    @Override
    public String getGid(int openid) {
        String gid=null;
        Csessioninfo csessioninfo =csessioninfoMapper.getGid(openid);
        gid = csessioninfo.getSessionKey();
        return gid;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void updateUserScore(int win, String openId) {
        int score = getScore(openId,"","");
        if(win==1){
            score=10;
            logger.info("玩家"+openId+"的分数增加"+score);
        }else if(win==0){
            score=-10;
            logger.info("玩家"+openId+"的分数减少"+score);
        }
        csessioninfoMapper.updateUserScore(score,openId);
    }

}
