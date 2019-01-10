package com.xmartech.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xmartech.chatbot"})
@EnableMongoRepositories({"com.xmartech.chatbot.repository"})
@EnableAutoConfiguration(exclude = {})
public class XmartechApplication {

  public static void main(String[] args) {
    SpringApplication.run(XmartechApplication.class, args);
  }
}
