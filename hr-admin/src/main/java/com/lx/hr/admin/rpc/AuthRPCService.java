package com.lx.hr.admin.rpc;

import com.lx.hr.admin.rpc.fallback.AuthRPCServiceFallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: WangYouzheng
 * @Date: 2021/8/2 17:55
 * @Description:
 */
@Component
@FeignClient(value = "auth", path = "/auth/test", fallback = AuthRPCServiceFallback.class)
public interface AuthRPCService {
	@PostMapping("/hystrix/test1")
	String hystrixTest1(String paramsString);
}
