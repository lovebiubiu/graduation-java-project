package com.ok.okhelper.GeccoTest;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

/**
 * Created by jackie on 18/1/15.
 */
@Getter
@Setter
@Gecco(matchUrl="https://nba.hupu.com/stats/players/pts", pipelines="teamPipeline")
public class TeamSort implements HtmlBean {
    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    // 表头
    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr.color_font1.bg_a > td")
    private List<String> title;

    //球员数据
    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr > td")
    private List<String> playerData;

    //球员姓名
    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr > td.left > a")
    private List<String> playerName;

    //球队姓名
    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr > td > a")
    private List<String> teamName;
}
