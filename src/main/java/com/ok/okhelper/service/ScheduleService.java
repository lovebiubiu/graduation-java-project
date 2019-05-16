package com.ok.okhelper.service;

import com.ok.okhelper.pojo.po.Schedule;
import com.ok.okhelper.pojo.po.ScheduleForecast;

import java.util.List;

public interface ScheduleService {
    public List<List<Schedule>> getSchedule();

    public List<ScheduleForecast> getForecast(String team1,String team2);
}
