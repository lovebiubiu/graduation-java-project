package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.FriendsnetworkMapper;
import com.ok.okhelper.pojo.po.Friendsnetwork;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
@Service
public class FriendsnetworkService {
    @Autowired
    FriendsnetworkMapper friendsnetworkMapper;

    Logger log = LoggerFactory.getLogger(this.getClass());

    public int addFriend(String openId1,String openId2){
        long getId =UidUtil.getInstance().nextId();
        String id = Long.toString(getId);
        Friendsnetwork friendsnetwork = new Friendsnetwork(id,openId1,"-1",openId2,"-1",new Date());
        Friendsnetwork temp = friendsnetworkMapper.selectFriend(openId1,openId2);
        if(temp!=null){
            log.info("--------------好友已存在--------------");
            return 0;
        }else if(temp==null){
            log.info("--------------添加好友--------------");
            friendsnetworkMapper.addFriend(friendsnetwork);
            getId = UidUtil.getInstance().nextId();
            id = Long.toString(getId);
            Friendsnetwork friendsnetwork_1 = new Friendsnetwork(id,openId2,"-1",openId1,"-1",new Date());
            friendsnetworkMapper.addFriend(friendsnetwork_1);
            return 1;
        }
        return -1;
    }
}
