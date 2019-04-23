package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Team;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "TeamMapper")
public interface TeamMapper extends MyMapper<Team> {
    @Override
    int insert(Team team);
}