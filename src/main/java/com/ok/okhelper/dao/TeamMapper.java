package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Team;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "TeamMapper")
public interface TeamMapper extends MyMapper<Team> {
    @Override
    int insert(Team team);

    @Override
    List<Team> selectAll();
}