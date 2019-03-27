package com.ok.okhelper.service;

import com.ok.okhelper.controller.WebSocketServer;
import com.ok.okhelper.pojo.po.QuestionDetail;
import com.ok.okhelper.pojo.po.Room;

import javax.websocket.Session;
import java.io.IOException;


public interface MatchService{
    Room createRoom(int sortId, Session session1, Session session2);

    public void toSendQuestion(String roomName) throws IOException;

    public void sendQuestion(String roomName) throws IOException;

    public void sendStatus(Room room) throws IOException, InterruptedException;
}
