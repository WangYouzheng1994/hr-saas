package com.lx.hr.admin.sa;

import cn.dev33.satoken.stp.StpInterfaceDefaultImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/11 08:44
 **/
@Slf4j
@Component
public class SaAuthorizeService extends StpInterfaceDefaultImpl {

	@Override
	public List<String> getPermissionList(Object loginId, String loginKey) {
		return new ArrayList<String>();
	}

	@Override
	public List<String> getRoleList(Object loginId, String loginKey) {
		return new ArrayList<String>();
	}
}
