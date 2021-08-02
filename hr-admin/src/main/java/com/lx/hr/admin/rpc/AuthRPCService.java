package com.lx.hr.admin.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: WangYouzheng
 * @Date: 2021/8/2 17:55
 * @Description:
 */
@Component
@FeignClient(value = "auth")
public interface AuthRPCService {
	@PostMapping("/auth/test/hystrix/test1")
	String hystrixTest1(String paramsString);
}
