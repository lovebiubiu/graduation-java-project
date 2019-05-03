package com.ok.okhelper.service;

import com.ok.okhelper.pojo.po.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getPlayerList();

    void initPlayerList();


}
