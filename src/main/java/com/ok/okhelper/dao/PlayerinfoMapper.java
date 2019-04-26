package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Playerinfo;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "PlayerinfoMapper")
public interface PlayerinfoMapper extends MyMapper<Playerinfo> {
    @Override
    int insert(Playerinfo playerinfo);
}