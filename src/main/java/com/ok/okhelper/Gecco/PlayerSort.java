package com.ok.okhelper.Gecco;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Gecco(matchUrl="https://nba.hupu.com/players/{player}", pipelines="playerPipeline")
public class PlayerSort implements HtmlBean {
    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    //球员姓名
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > h2")
    private String playerName;

    //球员信息
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div > div.font > p")
    private List<String> info;

    //球员数据
    @HtmlField(cssPath="#in_box > div > div:nth-child(1) > table.players_table.bott.bgs_table > tbody > tr > td")
    private List<String> playerData;

    //球员球队
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div > div.font > p:nth-child(5) > a")
    private String playerTeam;

    //球员头像
    @HtmlField(cssPath="body > div.gamecenter_livestart > div.gamecenter_content > div.gamecenter_content_l > div.team_data > div > div.content_a > div > div.img")
    private String playerAvatar;


}
