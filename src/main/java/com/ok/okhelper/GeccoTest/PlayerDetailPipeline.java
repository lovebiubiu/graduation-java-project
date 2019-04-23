package com.ok.okhelper.GeccoTest;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@PipelineName("playerPipeline")
public class PlayerDetailPipeline implements Pipeline<PlayerSort> {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void process(PlayerSort playerSort) {
        log.info("--------------------------process--------------------------------");
        List<String> infoList =playerSort.getInfo();
        String playerName = playerSort.getPlayerName();
        List<String> playerData = playerSort.getPlayerData();
        log.info("插入球员："+playerName);
    }
}
