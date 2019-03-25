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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Component
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    QuestionDetailMapper questionDetailMapper;

    private int MAX_SCORE_GAP = 10000;  //匹配的玩家最大分差不能超过10000分
    private int MATCH_SPEED = 3000; //匹配的频率:每3秒遍历匹配一次
    private int QUESTION_NUMBER= 5;//答题数5个
    private int SEND_QUESTIONS_DELAY= 3500;//匹配完成后，间隔3.5S后开始向前端发题
    private int SEND_QUESTION_TIME= 16000;//发题的频率：每16秒发送一题
    private int PING_PONG_TIME= 6000;//PING-PONG响应的PING发送频率
    private int PING_PONG_OUT_TIME= 20000;//PING-PONG响应超时时间
    private int MAX_NUMBER_TUNNEL_RESEND= 3;//每个信道允许出现无效信道时重新发送的次数



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
        String question = "";
        List<QuestionDetail> list  = new ArrayList<>();
        int sortId;
        Room room = WebSocketServer.getRoomItem(roomName);
        sortId = room.getSortId();
        if(sortId==1){
            list = questionDetailMapper.getRandomQuestionDetail(QUESTION_NUMBER);
        }else{
            list = questionDetailMapper.getQuestionDetail(sortId,QUESTION_NUMBER);
        }

        MyThread runnable = new MyThread();
        Thread thread = new Thread(runnable);
        runnable.getparams(list,room);
        thread.start();
    }
    class MyThread implements Runnable{
        String question="";
        List<QuestionDetail> list  = new ArrayList<>();
        Room room;
        public void getparams(List<QuestionDetail> list,Room room){
            this.list = list;
            this.room = room;
        }
        @Override
        public void run() {
            while(true){
                try {
                    System.out.println("-----------线程暂停-------------");
                    for(int i=0;i<QUESTION_NUMBER;i++){
                        question="sendQuestion"+"|"+list.get(i).getAsk()+"|"+list.get(i).getAnswer();
                        WebSocketServer.sendInfo(question,room.getPlayer1());
                        WebSocketServer.sendInfo(question,room.getPlayer2());
                        Thread.sleep(SEND_QUESTION_TIME);
                    }
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
//    public static void main(String[] args) {
//        createRoom(10);
//    }
}
