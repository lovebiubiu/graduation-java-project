package com.ok.okhelper.pojo.po;

import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;

@Getter
@Setter
public class Player {
    private Session session;
    private String avatarUrl;
    private String nickName;
    private int sortId;
    public Player(Session session,String nickName,int sortId,String avatarUrl){
        this.avatarUrl=avatarUrl;
        this.session=session;
        this.nickName=nickName;
        this.sortId=sortId;
    }
}
