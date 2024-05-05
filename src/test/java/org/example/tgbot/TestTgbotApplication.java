package org.example.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTgbotApplication {

    public static void main(String[] args) {
//        SpringApplication.from(TgbotApplication::main).with(TestTgbotApplication.class).run(args);
    }

}
