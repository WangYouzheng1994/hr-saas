package com.lx.hr.auth.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: WangYouzheng
 * @Date: 2021/8/2 11:47
 * @Description:
 */
@Service
@Slf4j
public class TestService {

	/**
	 * 设置3000秒超时 调用回调 testHystrixFallback
	 * @param params
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "testHystrixFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="3000")
	})
	public String testHystrix(String params) {
		return "normal";
	}

	public String testHystrixFallback(String params) {
		return "等等哈，我这处理的有点慢~";
	}
}
