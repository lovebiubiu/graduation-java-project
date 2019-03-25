package com.ok.okhelper.pojo.po;

import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;

@Getter
@Setter
public class Room {
    private int sortId;
    private String roomName;
    private Session player1;
    private Session player2;
    private String library;
    private String roomId;
    private int responseNumber;//收到的响应次数
    private boolean p1Ready = false;
    private boolean p2Ready = false;
    private boolean finished = false;

    public Room(String roomName,Session session1,Session session2,int sortId,int responseNumber){
        this.roomName = roomName;
        this.player1 = session1;
        this.player2 = session2;
        this.responseNumber = responseNumber;
        this.sortId = sortId;
    }

}
