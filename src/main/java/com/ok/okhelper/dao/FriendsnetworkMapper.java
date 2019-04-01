package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Friendsnetwork;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "FriendsnetworkMapper")
public interface FriendsnetworkMapper extends MyMapper<Friendsnetwork> {

    public Friendsnetwork selectFriend(String openId1,String openId2);

    public void addFriend(Friendsnetwork friendsnetwork);

}