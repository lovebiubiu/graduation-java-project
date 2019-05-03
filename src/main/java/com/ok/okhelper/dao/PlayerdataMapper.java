package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.PlayerRankList;
import com.ok.okhelper.pojo.po.Playerdata;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "PlayerdataMapper")
public interface PlayerdataMapper extends MyMapper<Playerdata> {
    @Override
    int insert(Playerdata playerdata);

    List<Playerdata> selectList(int pageNum);

    List<Playerdata> selectAllList();

    List<String> selectLength();


}