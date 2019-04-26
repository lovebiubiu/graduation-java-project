package com.ok.okhelper.GeccoTest;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.ok.okhelper.dao.NewsMapper;
import com.ok.okhelper.dao.PlayerMapper;
import com.ok.okhelper.dao.TeamMapper;
import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.Team;
import com.ok.okhelper.util.ApplicationContextRegister;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by xb
 */
@PipelineName("teamPipeline")
public class ProductDetailPipeline implements Pipeline<TeamSort> {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerMapper playerMapper;

    @Autowired
    TeamMapper teamMapper;

    @Override
    public void process(TeamSort teamSort) {
        log.info("--------------------------process--------------------------------");
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        teamMapper = act.getBean(TeamMapper.class);
        String teamName = teamSort.getTeamName();
        String[] str = teamName.split("（");
        str[0]=str[0].trim();
        str[1]=str[1].trim();
        str[1]=str[1].substring(0,str[1].length()-1);
        String enterNBA = teamSort.getEnterNBA();
        String str1[] = enterNBA.split("：");
        enterNBA = str1[1];
        String mainPlace = teamSort.getMainPlace();
        String str2[] = mainPlace.split("：");
        mainPlace = str2[1];
        str2 = mainPlace.split("分区");
        mainPlace = str2[0].trim();
        String webstation = teamSort.getWebstation();
        String coach = teamSort.getCoach();
        String str3[] = coach.split("：");
        coach = str3[1];
        String description = teamSort.getDescription();
        String id = Long.toString(UidUtil.getInstance().nextId());
        String nickName = teamSort.getRequest().getParameter("team");
        Team team = new Team(id,nickName,str[1],str[0],enterNBA,mainPlace,webstation,coach,description);
        log.info("插入球队："+teamName);
        teamMapper.insert(team);
    }

//    @Override
//    public void process(TeamSort teamSort) {
//        log.info("--------------------------process--------------------------------");
//        int ans=0;
//        List<String> list = teamSort.getPlayerData();
//        List<String> nameList = teamSort.getPlayerName();
//        List<String> teamList = teamSort.getTeamName();
//        for(int i = 0 ;i<12 ;i++){
//            list.remove(0);
//        }
//        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
//        playerMapper = act.getBean(PlayerMapper.class);
//        for(int i = 0 ; i<list.size();i+=12){
//            String str1[] = new String[2];
//            String str2[] = new String[2];
//            String str3[] = new String[2];
//            str1 = list.get(i+4).split("-");
//            str2 = list.get(i+6).split("-");
//            str3 = list.get(i+8).split("-");
//            String playerName = nameList.get(ans);
//            String playerTeam = teamList.get(ans);
//            double playerScore = Double.parseDouble(list.get(i+3));
//            double hit = Double.parseDouble(str1[0]);
//            double shotNum = Double.parseDouble(str1[1]);
//            String hitRate = list.get(i+5);
//            double threePointHit = Double.parseDouble(str2[0]);
//            double threePointShotNum = Double.parseDouble(str2[1]);
//            String threePointHitRate = list.get(i+7);
//            double penaltyShotHit = Double.parseDouble(str3[0]);
//            double penaltyShotHitNum = Double.parseDouble(str3[1]);
//            String penaltyShotHitRate = list.get(i+9);
//            double contestNum = Double.parseDouble(list.get(i+10));
//            double contestTime = Double.parseDouble(list.get(i+11));
//            String id = Long.toString(UidUtil.getInstance().nextId());
//            Player player = new Player(id,playerName,playerTeam,playerScore,hit,shotNum,hitRate,threePointHit,threePointShotNum,threePointHitRate,penaltyShotHit,penaltyShotHitNum,penaltyShotHitRate,contestNum,contestTime);
//            playerMapper.insert(player);
//            ans++;
//        }

  //  }
}
