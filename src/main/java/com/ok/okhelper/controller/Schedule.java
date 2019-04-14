package com.ok.okhelper.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "赛程路由")
@RestController
public class Schedule {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "请求赛程",notes = "根据日期请求赛程")
    @GetMapping("/getSchedule")
    public void getSchedule(String Date){

    }
}
