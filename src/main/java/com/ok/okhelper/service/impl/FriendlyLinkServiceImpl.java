package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.FriendlylinkMapper;
import com.ok.okhelper.pojo.po.Friendlylink;
import com.ok.okhelper.service.FriendlyLinkService;
import com.ok.okhelper.util.UidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendlyLinkServiceImpl implements FriendlyLinkService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FriendlylinkMapper friendlylinkMapper;

    @Override
    public List<Friendlylink> getFriendlyLinkList() {
        return friendlylinkMapper.getList();
    }

    @Override
    public void insertFriendlyLink(String linkName, String linkUrl, String linkDescription) {
        String id = Long.toString(UidUtil.getInstance().nextId());
        Friendlylink friendlylink = new Friendlylink(id,linkName,linkUrl,linkDescription);
        friendlylinkMapper.insertFriendlyLink(friendlylink);
    }

    @Override
    public void deleteFriendlyLink(String id) {
        friendlylinkMapper.deleteFriendlyLink(id);
    }

}
