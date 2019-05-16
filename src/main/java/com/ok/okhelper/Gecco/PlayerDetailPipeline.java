package com.ok.okhelper.Gecco;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.ok.okhelper.dao.PlayerdataMapper;
import com.ok.okhelper.dao.PlayerinfoMapper;
import com.ok.okhelper.pojo.po.Playerdata;
import com.ok.okhelper.pojo.po.Playerinfo;
import com.ok.okhelper.util.ApplicationContextRegister;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

@PipelineName("playerPipeline")
public class PlayerDetailPipeline implements Pipeline<PlayerSort> {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlayerinfoMapper playerinfoMapper;
    @Autowired
    PlayerdataMapper playerdataMapper;
    @Override
    public void process(PlayerSort playerSort) {
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        playerinfoMapper = act.getBean(PlayerinfoMapper.class);
        playerdataMapper = act.getBean(PlayerdataMapper.class);
        log.info("--------------------------process--------------------------------");
        List<String> infoList =playerSort.getInfo();
        for(int i = 0 ;i < infoList.size();i++){
            String[] str = infoList.get(i).split("：");
            String temp = str[1];
            infoList.set(i,temp);
        }
        String playerName = playerSort.getPlayerName();
        String[] spliteStr = playerName.split("<");
        playerName = spliteStr[0];
        spliteStr = playerName.split("（");
        playerName = spliteStr[1].substring(0,spliteStr[1].length()-1);
        String chineseName = spliteStr[0];
        String playerAvatar = playerSort.getPlayerAvatar();
        String[] ava = playerAvatar.split("\"");
        playerAvatar = ava[1];
        List<String> playerData = playerSort.getPlayerData();
        String id = Long.toString(UidUtil.getInstance().nextId());
        String weizhi = infoList.get(0);
        String shengao = infoList.get(1);
        String tizhong = infoList.get(2);
        String shengri = infoList.get(3);
        String qiudui = playerSort.getPlayerTeam();
        Playerinfo playerinfo = new Playerinfo(id,playerName,chineseName,playerAvatar,weizhi,shengao,tizhong,shengri,qiudui);
        playerinfoMapper.insert(playerinfo);
        log.info("插入球员基本信息："+playerName);
        String id2,saiji,saijiqiudui,toulan,minzhong1,sanfen,minzhong2,faqiu,minzhong3;
        int changci,shoufa;
        double shijian,lanban,zhugong,qiangduan,gaimao,shiwu,fangui,defen;
        String playerId = id;
        for(int i = 18;i<playerData.size();i+=18){
            id2 = Long.toString(UidUtil.getInstance().nextId());
            saiji = playerData.get(i);
            saijiqiudui = playerData.get(i+1);
            changci = Integer.parseInt(playerData.get(i+2).trim());
            shoufa =Integer.parseInt(playerData.get(i+3).trim());
            shijian = Double.parseDouble(playerData.get(i+4).trim());
            toulan = playerData.get(i+5);
            minzhong1 = playerData.get(i+6);
            sanfen = playerData.get(i+7);
            minzhong2 = playerData.get(i+8);
            faqiu = playerData.get(i+9);
            minzhong3 = playerData.get(i+10);
            lanban = Double.parseDouble(playerData.get(i+11).trim());
            zhugong = Double.parseDouble(playerData.get(i+12).trim());
            qiangduan = Double.parseDouble(playerData.get(i+13).trim());
            gaimao = Double.parseDouble(playerData.get(i+14).trim());
            shiwu = Double.parseDouble(playerData.get(i+15).trim());
            fangui = Double.parseDouble(playerData.get(i+16).trim());
            defen = Double.parseDouble(playerData.get(i+17).trim());
            Playerdata playerdata = new Playerdata(id2,playerId,saiji,saijiqiudui,changci,shoufa,shijian,toulan,minzhong1,sanfen,minzhong2,faqiu,minzhong3,lanban,zhugong,qiangduan,gaimao,shiwu,fangui,defen);
            playerdataMapper.insert(playerdata);
            log.info("插入"+playerName+"球员"+saiji+"数据：");
        }
    }
}
