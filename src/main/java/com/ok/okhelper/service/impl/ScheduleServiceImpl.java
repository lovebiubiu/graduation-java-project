package com.ok.okhelper.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ok.okhelper.service.ScheduleService;
import com.ok.okhelper.util.HttpClient;

import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    private static String url = "http://api.avatardata.cn/Nba/NomalRace?key=c72df233cf9046db8922149139c46d5e&format=true";

    private static List<ScheduleService> scheduleList ;
    @Override
    public void getSchedule(String Date) {
        String res = HttpClient.doPost(url,"GET");
        JSONObject jsonObject = JSONObject.parseObject(res);
        System.out.println(res);
    }
    public static void main(String[] arg0){
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        scheduleService.getSchedule("");
    }
}
