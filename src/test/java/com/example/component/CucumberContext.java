package com.example.component;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
    "com.example.component.actions",
    "com.example.component.config"
})
@PropertySource(value = {"classpath:application-test.yml"})
public class CucumberContext {

    @Autowired
    private WireMockServer exampleServiceWireMock;

    @Bean(destroyMethod = "stop")
    public WireMockServer exampleServiceMocked() {
        exampleServiceWireMock.start();
        return exampleServiceWireMock;
    }
}
