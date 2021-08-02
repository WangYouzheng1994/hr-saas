package com.lx.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 19:26
 **/
// @ComponentScan("com.lx.hr.admin")
@SpringBootApplication
// @RibbonClient(name="hr-auth", configuration = SpecRibbonRule.class)
@EnableEurekaServer
public class HrEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrEurekaApplication.class, args);
    }
}