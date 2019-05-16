package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Eloscore;
import com.ok.okhelper.pojo.po.Team;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "EloscoreMapper")
public interface EloscoreMapper extends MyMapper<Eloscore> {
    List<Team> getTeamList();
    @Override
    int insert(Eloscore eloscore);

    @Override
    List<Eloscore> selectAll();

    List<Eloscore> selectRankList();

    double selectRankOne(String teamName);

    void updateRankOne(String teamName,double rank);

    double getOneEloscore(String team);
}