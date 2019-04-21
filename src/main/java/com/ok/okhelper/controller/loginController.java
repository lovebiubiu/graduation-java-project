package com.ok.okhelper.controller;

import com.ok.okhelper.pojo.po.News;
import com.ok.okhelper.service.LoginService;
import com.ok.okhelper.shiro.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Api(tags = "登录相关")
@RestController
public class loginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "请求登录",notes = "根据用户名密码验证登录信息")
    @PostMapping("/loginValidate")
    public String loginValidate(@RequestParam("userName") String userName, @RequestParam("password") String password){
        logger.info(userName+"---------"+password);
        String token="";

        if(loginService.loginValidate(userName,password)==true){
            token = JWTUtil.sign(password,userName);
        }else{
            token = "-1";
        }
        return token;
    }

    @ApiOperation(value = "token验证",notes = "根据发送的token验证登录状态")
    @PostMapping("/tokenValidate")
    public int seccionValidate(@RequestParam("token") String token,@RequestParam("userName") String userName){
        if(JWTUtil.verify(token,userName)==true){
            logger.info("验证成功");
            return 1;
        }else{
            logger.info("验证失败");
            return -1;
        }
    }
}
