package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Csessioninfo;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component(value = "CsessioninfoMapper")
public interface CsessioninfoMapper extends MyMapper<Csessioninfo> {
    Csessioninfo getScore(String id);

    List<Csessioninfo> getRankGlobalData();

    List<Csessioninfo> getRankFriendsData();

    Csessioninfo getGid(int openid);
}