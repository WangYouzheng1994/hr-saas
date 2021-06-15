package com.lx.hr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDto;
import com.lx.hr.common.cfg.HrAuthProperties;
import com.lx.hr.entity.User;
import com.lx.hr.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@EnableConfigurationProperties(HrAuthProperties.class)
class HrWebApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HrAuthProperties hrAuthProperties;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        assertEquals(5, userList.size());
        userList.stream().map(User::toString).forEach(log::info);
        Page<User> page = userMapper.selectPage(PageDto.of(1, 2), new QueryWrapper<User>().select("id,name"));
        assertEquals(page.getTotal(), 5);
        assertEquals(page.getSize(), 2);
        page.getRecords().stream().map(User::toString).forEach(log::info);
    }

    @Test
    public void test() {
        log.info(hrAuthProperties.toString());
    }

}