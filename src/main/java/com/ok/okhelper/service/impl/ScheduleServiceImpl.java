package com.ok.okhelper.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ok.okhelper.dao.EloscoreMapper;
import com.ok.okhelper.pojo.po.Schedule;
import com.ok.okhelper.pojo.po.ScheduleForecast;
import com.ok.okhelper.service.ScheduleService;
import com.ok.okhelper.util.EloRating;
import com.ok.okhelper.util.HttpClient;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    EloscoreMapper eloscoreMapper;
    Logger log = LoggerFactory.getLogger(this.getClass());

    private static String url = "http://api.avatardata.cn/Nba/NomalRace?key=c72df233cf9046db8922149139c46d5e&format=true";

    private static List<ScheduleService> scheduleList ;
    @Override
    public List<List<Schedule>> getSchedule() {
        List<List<Schedule>> list = new ArrayList<>();
        String res = HttpClient.doPost(url,"GET");
        JSONObject jsonObject = JSONObject.parseObject(res);
        String res1 = jsonObject.getString("result");

        JSONObject jsonObject1 = JSONObject.parseObject(res1);
        jsonObject1.remove("statuslist");
        jsonObject1.remove("teammatch");
        jsonObject1.remove("title");
        JSONArray jsonArray = jsonObject1.getJSONArray("list");
        for(int i = 0;i<jsonArray.size();i++){
            Schedule temp = new Schedule();
            JSONObject jsonTemp = jsonArray.getJSONObject(i);
            temp.setTitle(jsonTemp.getString("title"));
            List<Schedule> scheduleList = new ArrayList<>();
            scheduleList.add(temp);
            JSONArray jsonArray1 = jsonTemp.getJSONArray("tr");
            for(int j = 0 ; j<jsonArray1.size();j++){
                jsonTemp = jsonArray1.getJSONObject(j);
                Schedule temp1 = new Schedule(null,null,jsonTemp.getString("player1"),jsonTemp.getString("player1logo"),jsonTemp.getString("player1logobig"),jsonTemp.getString("player1url"),jsonTemp.getString("player2"),jsonTemp.getString("player2logo"),jsonTemp.getString("player2logobig"),jsonTemp.getString("player2url"),jsonTemp.getString("score"),jsonTemp.getString("status"),jsonTemp.getString("time"));
                scheduleList.add(temp1);
            }
            list.add(scheduleList);
        }
//        System.out.println(res);
        return list;
    }

    @Override
    public List<ScheduleForecast> getForecast(String team1,String team2) {
        ScheduleForecast forecast1 = new ScheduleForecast();
        ScheduleForecast forecast2 = new ScheduleForecast();
        forecast1.setRank(eloscoreMapper.getOneEloscore(team1));
        forecast2.setRank(eloscoreMapper.getOneEloscore(team2));
        EloRating eloRating = new EloRating();
        eloRating.setRating_A(forecast1.getRank());
        eloRating.setRating_B(forecast2.getRank());
        double rank1 = eloRating.getWinRating();
        double rank2 = 1-rank1;
        forecast1.setRate(rank1);
        forecast2.setRate(rank2);
        List<ScheduleForecast> list = new ArrayList<>();
        list.add(forecast1);
        list.add(forecast2);
        return list;
    }

    public static void main(String[] arg0){
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        scheduleService.getSchedule();
    }
}
