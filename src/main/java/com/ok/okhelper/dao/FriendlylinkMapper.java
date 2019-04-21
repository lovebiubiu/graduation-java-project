package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Friendlylink;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "FriendlylinkMapper")
public interface FriendlylinkMapper extends MyMapper<Friendlylink> {
    public List<Friendlylink> getList();

    public void insertFriendlyLink(Friendlylink friendlylink);

    public void deleteFriendlyLink(String id);
}