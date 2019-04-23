package com.ok.okhelper.GeccoTest;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
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
@Gecco(matchUrl="https://nba.hupu.com/teams/{team}", pipelines="teamPipeline")
public class TeamSort implements HtmlBean {
    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    //球队名称
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > h2 > span.title-text")
    private String teamName;

    //进入NBA时间
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div.clearfix > div.font > p:nth-child(1)")
    private String enterNBA;

    //主场
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div.clearfix > div.font > p:nth-child(2)")
    private String mainPlace;



    //官网
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div.clearfix > div.font > p:nth-child(3)")
    private String webstation;

    //教练
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div.clearfix > div.font > p:nth-child(4)")
    private String coach;

    //简介
    @HtmlField(cssPath=" body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div.txt")
    private String description;

    //球员列表
    @Href(click=true)
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_list_data > div.jiben_title_table > div.a > div > span.c2 > a")
    private List<String> playerList;

    public static void main(String[] rags) {
        System.out.println("=======start========");
        HttpGetRequest startUrl = new HttpGetRequest("https://nba.hupu.com/teams/rockets");
        startUrl.setCharset("GBK");
        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("com.ok.okhelper.GeccoTest")
                //开始抓取的页面地址
                .start(startUrl)
                //开启几个爬虫线程
                .thread(10)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .run();
    }
//    // 表头
//    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr.color_font1.bg_a > td")
//    private List<String> title;
//
//    //球员数据
//    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr > td")
//    private List<String> playerData;
//
//    //球员姓名
//    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr > td.left > a")
//    private List<String> playerName;
//
//    //球队姓名
//    @HtmlField(cssPath="#data_js > div.table_data > div > table > tbody > tr > td:nth-child(3) > a")
//    private List<String> teamName;
}
