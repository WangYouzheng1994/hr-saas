package com.lx.hr.admin.service.login;

import cn.dev33.satoken.stp.StpUtil;
import com.lx.hr.admin.common.ServiceResult;
import com.lx.hr.admin.entity.LxHrBaseUser;
import org.springframework.stereotype.Service;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/30 20:39
 * @Description: 默认的登陆，存入userId
 */
@Service
public class DefaultLoginServiceImpl extends AbstractLoginService {
	@Override
	protected ServiceResult loginHandle(LxHrBaseUser lxHrBaseUser) {
		StpUtil.setLoginId(lxHrBaseUser.getPid());

		return ServiceResult.createSuccess(StpUtil.getTokenValue());
	}
}