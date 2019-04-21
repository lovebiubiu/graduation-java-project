package com.ok.okhelper.GeccoTest;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by jackie on 18/1/15.
 */
@PipelineName("teamPipeline")
public class ProductDetailPipeline  implements Pipeline<TeamSort> {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void process(TeamSort teamSort) {
        log.info("--------------------------process--------------------------------");
        int ans=0;
        List<String> list = teamSort.getPlayerData();
        List<String> nameList = teamSort.getPlayerName();
        List<String> teamList = teamSort.getTeamName();
        for(int i = 0 ;i<12 ;i++){
            list.remove(0);
        }
        for(int i = 0 ; i<list.size();i++){
            String playerName = nameList.get(ans);
            String playerTeam = teamList.get(ans);
            int playerScore = Integer.parseInt(list.get(i+1));
            int hit = Integer.parseInt(list.get(i+2));
            int shotNum = Integer.parseInt(list.get(i+1));
            double hitRate = Double.parseDouble(list.get(i+1));
            int threePointHit = Integer.parseInt(list.get(i+1));
            int threePointShotNum = Integer.parseInt(list.get(i+1));
            double threePointHitRate = Double.parseDouble(list.get(i+1));
            int penaltyShotHit = Integer.parseInt(list.get(i+1));
            int penaltyShotHitNum = Integer.parseInt(list.get(i+1));
            double penaltyShotHitRate = Double.parseDouble(list.get(i+1));
            int contestNum = Integer.parseInt(list.get(i+1));
            double contestTime = Double.parseDouble(list.get(i+1));
            //PlayerInfo player = new PlayerInfo(playerName,playerTeam,playerScore,hit,shotNum,hitRate,threePointHit,threePointShotNum,threePointHitRate,penaltyShotHit,penaltyShotHitNum,penaltyShotHitRate,contestNum,contestTime);
            ans++;
        }

        System.out.println(teamSort.getPlayerData());
//        for(int i=0 ; i<teamSort.getTitle().size();i++){
//            log.info("title "+teamSort.getTitle().get(i));
//        }
//        for(int i=0;i<teamSort.getPlayerData().size();i++){
//            String str = teamSort.getPlayerData().get(i);
//            log.info("--------tr--------");
//            log.info(str);
//        }
    }
}
