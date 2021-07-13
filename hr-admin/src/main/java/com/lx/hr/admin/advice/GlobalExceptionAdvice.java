package com.lx.hr.admin.advice;

import cn.dev33.satoken.exception.*;
import com.lx.hr.common.constant.CodeEnum;
import com.lx.hr.common.rest.RestExceptionAdvice;
import com.lx.hr.common.vo.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/10 19:05
 **/
@Slf4j
@RestControllerAdvice("com.lx.hr.admin")
public class GlobalExceptionAdvice extends RestExceptionAdvice {

    @ExceptionHandler(SaTokenException.class)
    public RespData<Object> handleSaException(SaTokenException e, HttpServletRequest request) {
        log.error("Request: " + request.getRequestURI(), e);
        if (e instanceof NotLoginException) {
            return RespData.builder().code(CodeEnum.A000000).message(e.getMessage()).build();
        } else if(e instanceof NotRoleException) {
            return RespData.builder().code(CodeEnum.C000010).message(e.getMessage()).build();
        } else if(e instanceof NotPermissionException) {
            return RespData.builder().code(CodeEnum.C000020).message(e.getMessage()).build();
        } else if(e instanceof DisableLoginException) {
            return RespData.builder().code(CodeEnum.C000030).message(e.getMessage()).build();
        }
        return RespData.builder().code(CodeEnum.S000000).message(CodeEnum.S000000.getMessage()).build();
    }

}
