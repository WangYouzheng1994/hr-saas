package com.lx.hr.admin.rpc.fallback;

import com.lx.hr.admin.rpc.AuthRPCService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: WangYouzheng
 * @Date: 2021/8/3 15:11
 * @Description:
 */
@Slf4j
public class AuthRPCServiceFallback implements AuthRPCService {
	@Override
	public String hystrixTest1(String paramsString) {
		log.warn("hystrixTest1 fallback");
		return "hystrixTest1 fallback";
	}
}
