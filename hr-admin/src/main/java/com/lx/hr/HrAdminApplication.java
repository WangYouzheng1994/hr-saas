package com.lx.hr;

import com.lx.ribbon.rule.SpecRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 19:26
 **/
// @ComponentScan("com.lx.hr.admin.*")
@SpringBootApplication
@RibbonClient(name="hr-auth", configuration = SpecRibbonRule.class)
@EnableFeignClients
@EnableHystrix
// @EntityScan("com.lx.hr.admin.entity.*")
public class HrAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrAdminApplication.class, args);
    }
}