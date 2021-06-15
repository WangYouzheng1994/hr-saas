package com.lx.hr.common.rest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lx.hr.common.vo.RespData;
import com.lx.hr.common.vo.RespDataPageable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Global rest data advice, inject as bean and @ControllerAdvice(package)
 *
 * @author zhufeifei
 * @date 2021/06/09 18:52
 **/
@Slf4j
public class RestResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean ignore = returnType.getExecutable().getAnnotation(RestWrapIgnore.class) != null;
        if (log.isDebugEnabled()) {
            log.debug("Invoke: {}, converterType: {}, ignore: {}", returnType.getMethod(), converterType, ignore);
        }
        ignore = ignore || !MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
        return !ignore;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType
            , MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType
            , ServerHttpRequest request, ServerHttpResponse response) {
        if (log.isDebugEnabled()) {
            log.debug("BeforeBodyWrite: {}, return: {}, contentType: {}, selectedConverterType: {}, request: {}"
                    , returnType.getMethod(), body != null ? body.getClass() : null
                    , selectedContentType, selectedConverterType, request.getURI());
        }
        if (selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            body = this.wrap(body);
        }
        return body;
    }

    private Object wrap(Object body) {
        if (body == null) {
            return RespData.builder().data("");
        } else if (body.getClass().isAssignableFrom(RespData.class)) {
            return body;
        } else if (body.getClass().isAssignableFrom(IPage.class)) {
            return RespDataPageable.builder()
                    .pages(((IPage<?>) body).getPages()).total(((IPage<?>) body).getTotal())
                    .data(((IPage<?>) body).getRecords())
                    .build();
        }
        return RespData.builder().data(body).build();
    }

}
