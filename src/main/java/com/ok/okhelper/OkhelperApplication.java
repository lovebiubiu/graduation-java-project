package com.ok.okhelper;

import com.ok.okhelper.controller.WebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @SpringbootApplication 相当于 @Configuration, @EnableAutoConfiguration 和 @ComponentScan 并具有他们的默认属性值
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.ok.okhelper.dao"})
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class OkhelperApplication {
    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(OkhelperApplication.class);
//        //SpringApplication.run(OkhelperApplication.class, args);
//        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
//        //解决WebSocket不能注入的问题
//        WebSocketServer.setApplicationContext(configurableApplicationContext);
        SpringApplication.run(OkhelperApplication.class, args);
    }
}
