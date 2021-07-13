package com.lx.hr.admin.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * @Author: WangYouzheng
 * @Date: 2021/6/30 13:53
 * @Description: Jackson，线程级复用，tomcat的线程池也不会妨碍这里。问题不大
 */
@Slf4j
public class JSONUtil {
	private static final ThreadLocal<ObjectMapper> writer = new ThreadLocal();
	private static final ThreadLocal<ObjectReader> reader = new ThreadLocal();

	public static <T extends Object> T jsonToObject(String jsonStr, Class<T> convertClass) {
		try {
			return getObjectMapper().readValue(jsonStr, convertClass);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
			throw new HrAdminException("JSON反序列化异常：【", jsonStr, "】");
		}
	}

	public static String getJSONString(Object obj) {
		try {
			return getObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage(), e);
		}
		return StringUtils.EMPTY;
	}

	public static String getPrettyJSONString() {
		Assert.isTrue(false, "not ready");
		return "";
	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = null;
		if (writer.get() != null) {
			objectMapper = writer.get();
		} else {
			// XXX:不需要DCL或者同步
			objectMapper = new ObjectMapper();
			writer.set(objectMapper);
		}

		return objectMapper;
	}
}
