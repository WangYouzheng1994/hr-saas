package com.lx.hr.common.rest;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 20:13
 **/
public class RestWebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = super.createRequestMappingHandlerAdapter();
        adapter.setResponseBodyAdvice(Collections.singletonList(new RestResponseBodyAdvice()));
        return adapter;
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(m -> {
            if (m instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) m).setSupportedMediaTypes(
                        Arrays.asList(MediaType.TEXT_HTML, MediaType.TEXT_EVENT_STREAM, MediaType.TEXT_PLAIN
                                , MediaType.TEXT_MARKDOWN, MediaType.TEXT_XML));
            }
        });
    }

}
