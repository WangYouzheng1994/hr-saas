package com.lx.hr.admin.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/30 14:57
 * @Description:
 */
@Slf4j
public class DateUtils {
	@Data
	static class Dog {
		String name = "321";
		String namefdsa = "3fffff21";
	}
	public static void main(String[] args) {
		String json = JSONUtil.getJSONString(new Dog());
		Dog dog = JSONUtil.jsonToObject(json, Dog.class);
		System.out.println(JSONUtil.getJSONString(dog));

		System.out.println(new HrAdminException("321321", "321321", "555555555fdfdas"));
	}
}
