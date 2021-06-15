package com.lx.hr.common.rest;

import com.lx.hr.common.constant.CodeEnum;
import com.lx.hr.common.exception.BizException;
import com.lx.hr.common.vo.RespData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/10 19:05
 **/
@Slf4j
public class RestExceptionAdvice {

    @ExceptionHandler(BizException.class)
    public RespData<Object> handleBizException(BizException e, HttpServletRequest request) {
        log.error("Request: " + request.getRequestURI(), e);
        return RespData.builder().code(e.getCode()).message(e.getMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    public RespData<Object> handleException(Exception e, HttpServletRequest request) {
        log.error("Request: " + request.getRequestURI(), e);
        return RespData.builder().code(CodeEnum.S000000).message(CodeEnum.S000000.getMessage()).build();
    }


}
