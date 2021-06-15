package com.lx.hr.web;

import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.stp.StpUtil;
import com.lx.hr.common.constant.CodeEnum;
import com.lx.hr.common.exception.BizException;
import com.lx.hr.common.rest.RestWrapIgnore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 20:02
 **/
@RestController
@RequestMapping("demo")
public class DemoController {

    @PostMapping
    public String login(String username, String password) {
        StpUtil.setLoginId(10001);
        return "Hello";
    }

    @RestWrapIgnore
    @GetMapping
    public boolean isLogin(String username) {
        return StpUtil.isLogin();
    }

    @GetMapping("biz")
    public String biz() {
        throw new BizException(CodeEnum.S000000, "Biz runtime exception!");
    }

    @GetMapping("sa")
    public String sa() {
        throw new NotPermissionException("No perm exception!");
    }

    @GetMapping("err")
    public String err() {
        throw new RuntimeException("Normal exception!");
    }
}
