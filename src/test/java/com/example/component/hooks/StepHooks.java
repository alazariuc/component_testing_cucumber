package com.example.component.hooks;

import com.example.Application;
import com.example.component.CucumberContext;
import com.example.component.aspects.SecurityAspect;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ConnectionConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.concurrent.TimeUnit;

@Slf4j
@CucumberContextConfiguration
@ContextConfiguration(classes = {CucumberContext.class})
@Import(SecurityAspect.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StepHooks {

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        setupRestAssured();
        log.info("StepHooks initialized");
    }

    private void setupRestAssured() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
            .setPort(port)
            .addFilter(new RequestLoggingFilter(LogDetail.ALL, true, System.out))
            .addFilter(new ResponseLoggingFilter(LogDetail.ALL, true, System.out))
            .setConfig(RestAssured.config()
                .connectionConfig(ConnectionConfig.connectionConfig()
                    .closeIdleConnectionsAfterEachResponseAfter(5, TimeUnit.SECONDS)));

        RestAssured.requestSpecification = builder.build();
    }
}
