package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.PlayerMapper;
import com.ok.okhelper.dao.PlayerdataMapper;
import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.Playerdata;
import com.ok.okhelper.service.PlayerService;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * create by xb
 * 2019/4/30
 得分准则 = [(得分+篮板+助攻+抢断+封盖)-(出手次数-命中次数)-(罚球次数-罚球命中次数)-失误次数]/球员上场比赛的场次
 *
 * */
@Service
public class PlayerServiceImpl implements PlayerService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlayerMapper playerMapper;

    @Autowired
    PlayerdataMapper playerdataMapper;
    @Override
    public List<Player> getPlayerList() {
        List<Player> list = new ArrayList<>();
        list = playerMapper.getPlayerList();
        return list;
    }
    public void initPlayerList(){
         List<Playerdata> list = playerdataMapper.selectAllList();
        double rank;
        String id;
        for(int i = 0 ;i<list.size();i++){
            Playerdata temp = list.get(i);
            rank = getRank(temp);
            Player player = playerMapper.checkPlayer(temp.getPlayerid());
            if(player!=null){
                player.setPlayerrank(rank);
                player.setPlayerteam(temp.getQiudui());
                playerMapper.updatePlayer(player);
                logger.info("球员"+player.getPlayerid()+"  更新rank="+rank);
            }else{
                id = Long.toString(UidUtil.getInstance().nextId());
                player = new Player(id,temp.getPlayerid(),temp.getQiudui(),rank);
                logger.info("球员"+player.getPlayerid()+" 插入rank="+rank);
                playerMapper.insert(player);
            }
        }
    }
    public double getRank(Playerdata playerdata){
        // 得分准则 = [(得分+篮板+助攻+抢断+封盖)-(出手次数-命中次数)-(罚球次数-罚球命中次数)-失误次数]/球员上场比赛的场次
        double chushou,minzhong,faqiu,faqiuminzhong;
        String[] tempArray;
        String temp;
        tempArray = playerdata.getToulan().split("-");
        chushou = Double.parseDouble(tempArray[1].trim());
        minzhong = Double.parseDouble(tempArray[0].trim());
        tempArray = playerdata.getFaqiu().split("-");
        faqiu = Double.parseDouble(tempArray[1].trim());
        faqiuminzhong = Double.parseDouble(tempArray[0].trim());
        double rank = (playerdata.getDefen()+playerdata.getLanban()+playerdata.getZhugong()+playerdata.getQiangduan()+playerdata.getGaimao())-(chushou-minzhong)-(faqiu-faqiuminzhong)-playerdata.getShiwu();
        return rank;
    }
}
