package com.lx.hr.cfg;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import com.lx.hr.common.cfg.HrAuthProperties;
import com.lx.hr.common.rest.RestWebMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 20:13
 **/
@Configuration
@EnableConfigurationProperties(HrAuthProperties.class)
public class WebMvcConfig extends RestWebMvcConfig {

    private HrAuthProperties hrAuthProperties;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaAnnotationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(hrAuthProperties.getExcludePath())
        ;
    }

    @Autowired
    public void setHrAuthProperties(HrAuthProperties hrAuthProperties) {
        this.hrAuthProperties = hrAuthProperties;
    }
}
