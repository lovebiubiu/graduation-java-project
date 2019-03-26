package com.ok.okhelper.pojo.po;

import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;

@Getter
@Setter
public class Player {
    private String openId;
    private Session session;
    private String avatarUrl;
    private String nickName;
    private int sortId;
    public Player(Session session,String nickName,int sortId,String avatarUrl,String openId){
        this.avatarUrl=avatarUrl;
        this.session=session;
        this.nickName=nickName;
        this.sortId=sortId;
        this.openId=openId;
    }
}
