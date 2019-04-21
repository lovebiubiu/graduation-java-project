package com.ok.okhelper.dao;

import com.ok.okhelper.pojo.po.Admin;
import com.ok.okhelper.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "AdminMapper")
public interface AdminMapper extends MyMapper<Admin> {
    public Admin selectAdmin(String userName,String password);
}