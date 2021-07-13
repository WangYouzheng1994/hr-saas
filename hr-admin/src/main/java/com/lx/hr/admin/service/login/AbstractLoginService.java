package com.lx.hr.admin.service.login;

import cn.dev33.satoken.stp.StpUtil;
import com.lx.hr.admin.common.ServiceResult;
import com.lx.hr.admin.entity.LxHrBaseUser;
import com.lx.hr.admin.entity.UserLogin;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/30 20:22
 * @Description: 提供必须的校验
 */
public abstract class AbstractLoginService implements LoginService {
	/**
	 * 用户登陆
	 *
	 * @param userLogin
	 * @return
	 */
	@Override
	public ServiceResult login(UserLogin userLogin) {
		// 获取账号密码 判空
		boolean valid = validLoginParam(userLogin);
		if (!valid) {
			return ServiceResult.createError("账户密码不得为空");
		}
		// 数据库校验
		ServiceResult<LxHrBaseUser> result = validLoginDBParam(userLogin);
		if (result.isFail()) {
			return ServiceResult.createError("账户或密码错误");
		}

		return loginHandle(result.getResult());
	}

	protected abstract ServiceResult loginHandle(LxHrBaseUser lxHrBaseUser);

	/**
	 * 数据库校验
	 *
	 * @param userLogin
	 * @return
	 */
	private ServiceResult validLoginDBParam(UserLogin userLogin) {
		return new ServiceResult();
	}

	/**
	 * 获取账号密码 判空
	 *
	 * @param userLogin
	 * @return
	 */
	private boolean validLoginParam(UserLogin userLogin) {
		return false;
	}
}
