package com.lx.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @Author: WangYouzheng
 * @Date: 2021/7/28 17:42
 * @Description:
 */
@EnableCircuitBreaker
@SpringBootApplication
public class HrAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrAuthApplication.class, args);
	}
}
