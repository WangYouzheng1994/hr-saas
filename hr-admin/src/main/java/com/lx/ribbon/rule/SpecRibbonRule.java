package com.lx.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WangYouzheng
 * @Date: 2021/7/30 17:48
 * @Description: 使用随机算法
 */
@Configuration
public class SpecRibbonRule {
	@Bean
	public IRule getMyRule() {
		return new RandomRule();
	}
}
