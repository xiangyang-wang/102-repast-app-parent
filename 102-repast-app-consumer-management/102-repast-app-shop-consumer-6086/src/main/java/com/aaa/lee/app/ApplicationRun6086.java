package com.aaa.lee.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Company AAA软件教育
 * @Author 王向阳
 * @Date Create in 2019/12/20 21:38
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.aaa.lee.app"})
public class ApplicationRun6086 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6086.class,args);
    }
}
