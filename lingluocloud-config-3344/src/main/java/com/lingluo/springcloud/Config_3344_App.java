package com.lingluo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author
 * @date 2020/2/29 22:57
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344_App {
    public static void main(String[] args) {
        SpringApplication.run(Config_3344_App.class,args);
    }
}
