package com.lx.hr.admin.service.login;

import com.lx.hr.admin.common.ServiceResult;
import com.lx.hr.admin.entity.UserLogin;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/30 11:50
 * @Description: 登陆
 */
public interface LoginService {
	/**
	 * 用户登陆
	 *
	 * @param userLogin
	 * @return
	 */
	ServiceResult login(UserLogin userLogin);
}
