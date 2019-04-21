package com.ok.okhelper.pojo.po;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// Gecco注解中的matchUrl代表可被解析的url路径，pipelines代表一个处理管道，
//当路径页面被下载下来之后，能够通过管道类对封装到HtmlBean中的数据进行处理
//{page}代表一个路径匹配变量，这个变量可以在类中变量通过@RequestParam注解解析获得

@Getter
@Setter
@Gecco(matchUrl = "http://zj.zjol.com.cn/home.html?pageIndex={pageIndex}&pageSize={pageSize}",pipelines = "zJNewsListPipelines")
public class PlayerSpiderEntry implements HtmlBean {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Request
    private HttpRequest request;
    @RequestParameter
    private int pageIndex;
    @RequestParameter
    private int pageSize;
    @HtmlField(cssPath = "#content > div > div > div.con_index > div.r.main_mod > div > ul > li > dl > dt > a")
    private List<HrefBean> newList;

    public static void main(String [] rags){
        System.out.println("----------------------start-----------------------");
        HttpGetRequest httpGetRequest = new HttpGetRequest("http://news.iresearch.cn/");
        httpGetRequest.setCharset("GBK");
        GeccoEngine.create()
                //工程的包路径
                .classpath("com.ok.okhelper")
                //开始抓取的页面地址
                .start(httpGetRequest)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();
    }
}
