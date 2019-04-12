package com.ok.okhelper.pojo.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {
    private String picUrl;
    private String ctime;
    private String description;
    private String title ;
    private String url;
    News(String picUrl, String ctime, String description, String title, String url){
        this.picUrl=picUrl;
        this.ctime=ctime;
        this.description = description;
        this.title = title;
        this.url = url;
    }
}
