package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.ScrollpictureMapper;
import com.ok.okhelper.pojo.po.Scrollpicture;
import com.ok.okhelper.service.ScrollpictureService;
import com.ok.okhelper.util.UidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrollpictureServiceImpl implements ScrollpictureService {
    @Autowired
    ScrollpictureMapper scrollpictureMapper;
    @Override
    public void insertOne(String pictureUrl, String pictureTitle,String newsUrl) {
        String id = Long.toString(UidUtil.getInstance().nextId());
        Scrollpicture scrollpicture = new Scrollpicture(id,pictureUrl,pictureTitle,newsUrl);
        scrollpictureMapper.insertOne(scrollpicture);
    }

    @Override
    public void updateOne(String id, String pictureUrl, String pictureTitle,String newsUrl) {
        Scrollpicture scrollpicture = new Scrollpicture(id,pictureUrl,pictureTitle,newsUrl);
        scrollpictureMapper.updateOne(scrollpicture);
    }
}
