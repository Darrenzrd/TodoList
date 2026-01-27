package com.darren.todolist;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@Slf4j
public class TodoListApplicationTests {
    @Resource
    private ApplicationContext ctx;

    @Test
    void textCtx() {
        log.info("Application = {}" , ctx);
    }
}
