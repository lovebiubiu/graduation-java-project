package com.ok.okhelper.service.impl;

import com.ok.okhelper.controller.WebSocketServer;
import com.ok.okhelper.dao.QuestionDetailMapper;
import com.ok.okhelper.pojo.po.QuestionDetail;
import com.ok.okhelper.pojo.po.Room;
import com.ok.okhelper.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.*;

@Component
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    QuestionDetailMapper questionDetailMapper;

    //根据房间名控制发送答案的线程 主要控制用户都答题后立刻发送答案的业务

    private int MAX_SCORE_GAP = 10000;  //匹配的玩家最大分差不能超过10000分
    private int MATCH_SPEED = 3000; //匹配的频率:每3秒遍历匹配一次
    private int QUESTION_NUMBER= 5;//答题数5个
    private int SEND_QUESTIONS_DELAY= 3500;//匹配完成后，间隔3.5S后开始向前端发题
    private int SEND_QUESTION_TIME= 16000;//发题的频率：每16秒发送一题
    private int PING_PONG_TIME= 6000;//PING-PONG响应的PING发送频率
    private int PING_PONG_OUT_TIME= 20000;//PING-PONG响应超时时间
    private int MAX_NUMBER_TUNNEL_RESEND= 3;//每个信道允许出现无效信道时重新发送的次数

    List<QuestionDetail> list  = new ArrayList<>();

    public Room createRoom(int sortId, Session session1, Session session2){
        Random rand =new Random();
        long dateNum = new Date().getTime();
        int randomNum = rand.nextInt(1000000);
        String roomName = dateNum +""+randomNum;
        //System.out.println(roomName);
        Room room = new Room(roomName,session1,session2,sortId,0);
        return room;
    }

    public void toSendQuestion(String roomName) throws IOException {
        int sortId;
        Room room = WebSocketServer.getRoomItem(roomName);
        sortId = room.getSortId();
        if(sortId==1){
            list = questionDetailMapper.getRandomQuestionDetail(QUESTION_NUMBER);
        }else{
            list = questionDetailMapper.getQuestionDetail(sortId,QUESTION_NUMBER);
        }
        sendQuestion(roomName);

    }

    public void sendQuestion(String roomName) throws IOException {
        Room room = WebSocketServer.getRoomItem(roomName);
        String question;
        if(room!=null){
            int num = room.getAnswerNum();
            if(num<QUESTION_NUMBER){
                question="sendQuestion"+"|"+list.get(num).getAsk()+"|"+list.get(num).getAnswer();
                WebSocketServer.sendInfo(question,room.getPlayer1());
                WebSocketServer.sendInfo(question,room.getPlayer2());
                room.setPlayer1Choose(null);
                room.setPlayer2Choose(null);
                num++;
                room.setAnswerNum(num);
            }
        }

    }

    @Override
    public void sendStatus(Room room) throws IOException, InterruptedException {
        String openId,userChoose,answerColor,score,message1,message2;
        openId=null;
        userChoose=room.getPlayer1Choose();
        answerColor = room.getPlayer1AnswerColor();
        score = room.getPlayer1score();
        message1 = "sendOhterAnswer"+"|openId:"+openId+"|userChoose:"+userChoose+"|answerColor:"+answerColor+"|score:"+score;

        userChoose=room.getPlayer2Choose();
        answerColor = room.getPlayer2AnswerColor();
        score = room.getPlayer2score();
        message2 = "sendOhterAnswer"+"|openId:"+openId+"|userChoose:"+userChoose+"|answerColor:"+answerColor+"|score:"+score;

        WebSocketServer.sendInfo(message2,room.getPlayer1());
        WebSocketServer.sendInfo(message1,room.getPlayer2());
        MyThread runnable = new MyThread();
        runnable.getParams(room.getRoomName());
        Thread thread = new Thread(runnable);
        thread.start();
    }


    class MyThread implements Runnable{
        String roomName;

        public void getParams(String roomName) throws IOException, InterruptedException {
           this.roomName=roomName;
        }
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println("-----------线程暂停-------------");
                    Thread.sleep(2000);
                    sendQuestion(roomName);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
