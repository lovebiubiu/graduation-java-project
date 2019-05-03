package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.player_playerInfo;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "PlayerMapper")
public interface PlayerMapper extends MyMapper<Player> {
    @Override
    int insert(Player player);

    List<Player> getPlayerList();

    List<player_playerInfo> selectRankList();

    Player checkPlayer(String id);

    void updatePlayer(Player player);


}