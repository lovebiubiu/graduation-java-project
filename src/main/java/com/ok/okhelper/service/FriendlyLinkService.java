package com.ok.okhelper.service;

import com.ok.okhelper.pojo.po.Friendlylink;

import java.util.List;

public interface FriendlyLinkService {
    public List<Friendlylink> getFriendlyLinkList();

    public void insertFriendlyLink(String linkName,String linkUrl,String linkDescription);

    public void deleteFriendlyLink(String id);
}
