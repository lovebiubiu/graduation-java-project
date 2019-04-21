package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.PlayerMapper;
import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerMapper playerMapper;

    @Override
    public List<Player> getPlayerList() {
        List<Player> list = new ArrayList<>();
        list = playerMapper.getPlayerList();
        return list;
    }
}
