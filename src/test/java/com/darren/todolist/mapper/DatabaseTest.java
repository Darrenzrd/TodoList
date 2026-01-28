package com.darren.todolist.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DatabaseTest {


    @Autowired
    private TestMapper testMapper;

    @Test
    void testConnection() {
        Integer result = testMapper.testConnection();
        log.info("数据库连接成功");
    }
}
