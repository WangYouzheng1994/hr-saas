package com.lx.hr.admin.cfg;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 19:57
 **/
@Configuration
@MapperScan("com.lx.hr.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(@Value("${mybatis-plus.page.max-limit:-2000}") long maxLimit) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pi = new PaginationInnerInterceptor(DbType.MYSQL);
        pi.setMaxLimit(maxLimit);
        interceptor.addInnerInterceptor(pi);
        return interceptor;
    }
}
