package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Eloscore;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "EloscoreMapper")
public interface EloscoreMapper extends MyMapper<Eloscore> {
    @Override
    int insert(Eloscore eloscore);
}