package com.ok.okhelper.controller;

import com.ok.okhelper.pojo.po.Schedule;
import com.ok.okhelper.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "赛程路由")
@RestController
public class ScheduleController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ScheduleService scheduleService;

    @ApiOperation(value = "请求赛程",notes = "根据日期请求赛程")
    @GetMapping("/getSchedule")
    public List<List<Schedule>> getSchedule(){
        return scheduleService.getSchedule();
    }
}
