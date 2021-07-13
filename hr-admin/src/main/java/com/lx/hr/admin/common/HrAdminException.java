package com.lx.hr.admin.common;

import com.lx.hr.common.constant.CodeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/30 15:04
 * @Description:
 */
public class HrAdminException extends RuntimeException {
	public HrAdminException() {
		super();
	}

	public HrAdminException(String... msg) {
		super(StringUtils.join(msg));
	}
}
