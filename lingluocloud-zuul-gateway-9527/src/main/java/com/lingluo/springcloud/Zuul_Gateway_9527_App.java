package com.lingluo.springcloud;

import com.lingluo.springcloud.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author 灵洛
 * @date 2020/2/27 23:57
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul_Gateway_9527_App {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_Gateway_9527_App.class,args);
    }

    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }
}
