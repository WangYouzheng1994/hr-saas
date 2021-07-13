package com.lx.hr.admin.cfg;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouterUtil;
import cn.dev33.satoken.stp.StpUtil;
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

    /**
     * 拦截器配置
     * 后续静态资源考虑在这加配置
     * 并且注册sa登陆拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaAnnotationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/login")
                .excludePathPatterns(hrAuthProperties.getExcludePath())
        ;
    }

    @Autowired
    public void setHrAuthProperties(HrAuthProperties hrAuthProperties) {
        this.hrAuthProperties = hrAuthProperties;
    }
}
