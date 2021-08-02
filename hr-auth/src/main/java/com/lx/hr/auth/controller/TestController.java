package com.lx.hr.auth.controller;

import com.lx.hr.auth.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangYouzheng
 * @Date: 2021/8/2 11:46
 * @Description:
 */
@RestController
@RequestMapping
@Slf4j
public class TestController {
	@Autowired
	private TestService testService;
	@PostMapping("/hystrix/test1")
	public String hystrixTest1(String paramsString) {
		return testService.testHystrix(paramsString);
	}
}
