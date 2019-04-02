package com.ok.okhelper.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ok.okhelper.pojo.po.Player;
import com.ok.okhelper.pojo.po.QuestionSort;
import com.ok.okhelper.pojo.po.Room;


import com.ok.okhelper.service.MatchService;
import com.ok.okhelper.service.QuestionSortService;
import com.ok.okhelper.service.impl.MatchServiceImpl;
import com.ok.okhelper.util.ApplicationContextRegister;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Controller;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

@ServerEndpoint(value="/ws/{sid}")
@Controller
public class WebSocketServer {
    //private static ApplicationContext applicationContext;
    @Autowired
    private static MatchService matchService;

    @Autowired
    private static QuestionSortService questionSortService;


//    public static void setApplicationContext(ApplicationContext applicationContext) {
//        WebSocketServer.applicationContext = applicationContext;
//    }


    Logger log = LoggerFactory.getLogger(this.getClass());
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";

    //建立线程安全的阻塞队列，实现多线程同步
    private static List<LinkedBlockingDeque<Session>>  queuelist = new ArrayList<>(15);
    static {
        for(int i=0;i<15;i++){
            queuelist.add(new LinkedBlockingDeque<Session>());
        }
    }

    private static Map<Session, Player> playermap = new HashMap<>();

    private static Map<String, Room> roomMap = new HashMap<>();


    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) throws InterruptedException {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("有新窗口开始监听 openid:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        Player player = playermap.get(this.session);
        if(player!=null){
            int sortId = player.getSortId();
            queuelist.get(sortId).remove(this.session);
            playermap.remove(this.session);
            log.info("现在队列" + sortId + "长度为：" + queuelist.get(sortId).size());
        }
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(Session session, String message) throws InterruptedException, IOException {
        JSONArray jsonArray=JSON.parseArray(message);
        JSONObject obj = jsonArray.getJSONObject(0);        //json格式化处理为object
        String msgType = obj.getString("socketType");
        switch (msgType){
            case "join_match":
                ToCreateRoom(session,obj);
                break;
            case "ready_match":
                ToReadyMatch(session,obj);
                break;
            case "send_answer":
                ToSendOhterStatus(session,obj);
                break;
            case "send_result":
                getMatchResult(session,obj);
                break;
            case "atonce_send":
                atonceSendQuestion(obj);
                break;
            case "friend_match":
                CreateFriendRoom(session,obj);
                break;
            default:
                    break;
        }
    }

    /**
     * 2019/4/2
     * create by xb
     * 创建好友对战房间
     * */
    public void CreateFriendRoom(Session session,JSONObject obj) throws IOException {
        String roomName = obj.getString("roomName");
        Room temp = roomMap.get(roomName);
        int sortId = Integer.parseInt(obj.getString("sortId").trim());
        if(temp!=null){ //房间已存在
            if(temp.getPlayer2()!=null){       //两名玩家都已经在房间中 不能加入新的玩家
                sendInfo("error|room is fighting",session);
                return ;
            }
            else{   //加入第二名玩家
                Player player = new Player(session,obj.getString("nikeName"),Integer.parseInt(obj.getString("sortId").trim()),obj.getString("avatarUrl"),obj.getString("openId"));
                playermap.put(session,player);
                Player player1, player2;
                String msg;
                temp.setPlayer2(session);
                player1 = playermap.get(temp.getPlayer1());
                player2 = playermap.get(temp.getPlayer2());
                //向一号玩家发送消息
                msg = "roomName|" + temp.getRoomName() + "|roomId|" + temp.getRoomId() + "|nickName|" + player2.getNickName() + "|avatarUrl|" + player2.getAvatarUrl();                                      //发送的消息
                sendInfo(msg, temp.getPlayer1());
                //向二号玩家发送消息
                msg = "roomName|" + temp.getRoomName() + "|roomId|" + temp.getRoomId() + "|nickName|" + player1.getNickName() + "|avatarUrl|" + player1.getAvatarUrl();
                sendInfo(msg, temp.getPlayer2());
            }
        }else{      //加入第一名玩家
            log.info("第一个玩家进入，创建房间");
            Player player = new Player(session,obj.getString("nikeName"),Integer.parseInt(obj.getString("sortId").trim()),obj.getString("avatarUrl"),obj.getString("openId"));
            playermap.put(session,player);
            ApplicationContext act = ApplicationContextRegister.getApplicationContext();
            matchService = act.getBean(MatchService.class);
            Room room = matchService.createFriendRoom(sortId,session,roomName);
            roomMap.put(room.getRoomName(),room);
        }
    }

    /**
     * 2019/4/2
     * create by xb
     * 立刻发送下一题
     * */
    public void atonceSendQuestion(JSONObject obj) throws IOException {
        log.info("双方答题完毕，继续发送下一道题");
        String roomName;
        roomName = obj.getString("roomName");
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();
        matchService = act.getBean(MatchService.class);
        matchService.sendQuestion(roomName);
    }

    /**
     * 2019.3.26
     * create by xb
     * 保存比赛结果
     * */
    public void getMatchResult(Session session,JSONObject obj){
        String openId = obj.getString("openId");
        int res = Integer.parseInt(obj.getString("fightingResult"));
        String roomName = obj.getString("roomName");
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();    //socket使用Service层方法
        questionSortService = act.getBean(QuestionSortService.class);
        if(res==1){
            questionSortService.updateUserScore(1,openId);
        }else if(res==0){
            questionSortService.updateUserScore(0,openId);
        }
        playermap.remove(session);
        log.info("将玩家"+session+"从map中删除");
        if(roomMap.get(roomName)!=null){
            roomMap.remove(roomName);
            log.info("删除房间"+roomName);
        }
    }

    /**
     * 2019.3.25
     * create by xb
     * 发送玩家状态给另一玩家
     * */
    public void ToSendOhterStatus(Session session,JSONObject obj) throws IOException, InterruptedException {
        String openId = obj.getString("openId");
        String userChoose = obj.getString("userChoose");
        String answerColor = obj.getString("answerColor");
        String score = obj.getString("scoreMyself");
        String roomName = obj.getString("roomName");
        Room room = roomMap.get(roomName);
        if(session.getId().equals(room.getPlayer1().getId())){
            room.setPlayer1Choose(userChoose);
            room.setPlayer1AnswerColor(answerColor);
            room.setPlayer1score(score);
        }else{
            room.setPlayer2Choose(userChoose);
            room.setPlayer2AnswerColor(answerColor);
            room.setPlayer2score(score);
        }
        log.info(room.getPlayer1Choose()+"||"+room.getPlayer2Choose());
        if(room.getPlayer1Choose()!=null&&room.getPlayer2Choose()!=null){
            ApplicationContext act = ApplicationContextRegister.getApplicationContext();
            matchService = act.getBean(MatchService.class);
            matchService.sendStatus(room);
        }

    }

    /**
     * 2019.3.25
     * create by xb
     * 玩家已在房间中准备好
     * 如果两个玩家都准备好，比赛开始，发送题目给用户
     * */
    public void ToReadyMatch(Session session,JSONObject obj) throws IOException {
        String roomName;
        Session player1,player2;
        ApplicationContext act = ApplicationContextRegister.getApplicationContext();

        roomName = obj.getString("roomName");
        Room room = roomMap.get(roomName);
        player1 = room.getPlayer1();
        player2 = room.getPlayer2();
        if(session.getId().equals(player1.getId())){
            room.setP1Ready(true);
            sendInfo("玩家1已准备",player1);
        }else if(session.getId().equals(player2.getId())){
            room.setP2Ready(true);
            sendInfo("玩家2已准备",player2);
        }
        if(room.isP1Ready()&&room.isP2Ready()){
            log.info("------------------现在开始发送题目------------------");
            matchService = act.getBean(MatchService.class);
            matchService.toSendQuestion(roomName);
        }
    }


    /**
     *  2019.3.25
     *  create by xb
     *  玩家进入队列组队
     *  一旦队列中超过两人 则创建房间
     * */
    public void ToCreateRoom(Session session,JSONObject obj) throws InterruptedException, IOException {
        Player player = new Player(session,obj.getString("nickName"),Integer.parseInt(obj.getString("sortId").trim()),obj.getString("avatarUrl"),obj.getString("openid"));
        int sortId = player.getSortId();
        playermap.put(session,player);
        queuelist.get(sortId).put(session);
        log.info("队列"+sortId+"添加成员"+obj.getString("openId")+" 现在成员:"+queuelist.get(player.getSortId()).size()+"人");

        if(queuelist.get(sortId).size()>=2) {
            Session player1, player2;
            String msg;
            ApplicationContext act = ApplicationContextRegister.getApplicationContext();
            matchService = act.getBean(MatchService.class);
            player1 = queuelist.get(sortId).pollFirst();
            player2 = queuelist.get(sortId).pollFirst();
            Player temp1 = playermap.get(player2);
            Player temp2 = playermap.get(player1);

            Room room = matchService.createRoom(sortId,player1,player2);
            roomMap.put(room.getRoomName(),room);

            log.info("向用户发送房间和对手信息：" + room.getRoomName());
            /*
                向一号玩家发送消息
             */
            msg = "roomName|" + room.getRoomName() + "|roomId|" + room.getRoomId() + "|nickName|" + temp1.getNickName() + "|avatarUrl|" + temp1.getAvatarUrl();                                      //发送的消息
            sendInfo(msg, player1);
            /*
                向二号玩家发送消息
             */
            msg = "roomName|" + room.getRoomName() + "|roomId|" + room.getRoomId() + "|nickName|" + temp2.getNickName() + "|avatarUrl|" + temp2.getAvatarUrl();
            sendInfo(msg, player2);

            log.info("现在队列" + sortId + "长度为：" + queuelist.get(sortId).size());
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("session") Session session) throws IOException {
//        log.info("推送消息到窗口"+sid+"，推送内容:"+message);
        System.out.println("推送消息到窗口"+session+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(session==null) {
                    item.sendMessage(message);
                }else if(item.session.equals(session)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static Room  getRoomItem(String roomName){
        return roomMap.get(roomName);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
