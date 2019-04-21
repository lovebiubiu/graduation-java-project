package com.ok.okhelper.service.impl;

import com.ok.okhelper.dao.AdminMapper;
import com.ok.okhelper.pojo.po.Admin;
import com.ok.okhelper.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AdminMapper adminMapper;
    @Override
    public boolean loginValidate(String userName, String password) {
        Admin admin = adminMapper.selectAdmin(userName,password);
        if(admin!=null){
            logger.info("用户存在,登录成功");
            return true;
        }else{
            logger.info("用户不存在，登录失败");
            return false;
        }
    }

    @Override
    public boolean loginStateValidate(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.isNew()==false) {
            return true;
        }
        return false;
    }
}
