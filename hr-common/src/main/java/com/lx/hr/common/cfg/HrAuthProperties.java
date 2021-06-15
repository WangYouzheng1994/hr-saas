package com.lx.hr.common.cfg;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/10 19:14
 **/
@Data
@Component
@ConfigurationProperties(prefix = HrAuthProperties.HR_AUTH_PREFIX)
public class HrAuthProperties {

    static final String HR_AUTH_PREFIX = "hr.auth";

    private List<String> excludePath;

}
