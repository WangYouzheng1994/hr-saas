package com.lx.hr.admin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.lx.hr.admin.common.ServiceResult;
import com.lx.hr.admin.entity.UserLogin;
import com.lx.hr.admin.service.login.LoginService;
import com.lx.hr.common.constant.CodeEnum;
import com.lx.hr.common.vo.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/16 17:22
 * @Description: 登录 鉴权
 */
@RequestMapping("login")
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;


	@PostMapping("/login")
	public RespData login(@RequestBody UserLogin userLogin) {

		ServiceResult loginResult = this.loginService.login(userLogin);
		return loginResult.serviceToRespData();
	}
}
