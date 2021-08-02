package com.lx.hr.admin.controller;

import com.lx.hr.admin.rpc.AuthRPCService;
import com.lx.hr.common.constant.CodeEnum;
import com.lx.hr.common.vo.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/16 11:50
 * @Description:
 */
@RequestMapping("/User")
@RestController
public class UserController {
	@Autowired
	private AuthRPCService authRPCService;

	public RespData getParameter() {
		return RespData.builder().code(CodeEnum.C000020).build();
	}

	@GetMapping("rpcHystrix")
	public String testRPCHystrix() {
		return this.authRPCService.hystrixTest1("ying?");
	}
}