package com.ok.okhelper.Gecco;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Gecco(matchUrl="https://nba.hupu.com/teams", pipelines="allPipeline")
public class AllSort implements HtmlBean {
    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    //球队列表
    @Href(click=true)
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div > div.teamlist_box_r > div > div.team > a")
    private List<String> teamList;


}
