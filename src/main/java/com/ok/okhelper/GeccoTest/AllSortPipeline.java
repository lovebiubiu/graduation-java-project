package com.ok.okhelper.GeccoTest;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@PipelineName("allPipeline")
public class AllSortPipeline  implements Pipeline<AllSort> {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public void process(AllSort allSort) {
        log.info("--------------------------process--------------------------------");
        log.info("进入球队链接");
    }
}
