package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Scrollpicture;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "ScrollpictureMapper")
public interface ScrollpictureMapper extends MyMapper<Scrollpicture> {

    List<Scrollpicture> selectList();


    int insertOne(Scrollpicture scrollpicture);


    int deleteOne(String id);


    int updateOne(Scrollpicture scrollpicture);
}