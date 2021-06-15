package com.lx.hr.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void login() {
        Object result = restTemplate.exchange(
                RequestEntity
                        .post("/demo")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .body("username=a&password=b")
                , Object.class);
        System.out.println(result);
    }

    @Test
    void isLogin() {
        Object result = restTemplate.getForObject("/demo", Object.class);
        System.out.println(result);
    }

    @Test
    void biz() {
        Object result = restTemplate.getForObject("/demo/biz", Object.class);
        System.out.println(result);
    }

    @Test
    void sa() {
        Object result = restTemplate.getForObject("/demo/sa", Object.class);
        System.out.println(result);
    }

    @Test
    void err() {
        Object result = restTemplate.getForObject("/demo/err", Object.class);
        System.out.println(result);
    }

}