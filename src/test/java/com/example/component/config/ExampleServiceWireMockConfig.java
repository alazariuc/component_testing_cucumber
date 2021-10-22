package com.example.component.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

@Configuration
public class ExampleServiceWireMockConfig {

    /*@Value("example-service.port")
    private int feedbackServicePort;*/

    @Bean
    public WireMockServer exampleServiceWireMock() {
        return new WireMockServer(options()
            .port(8081)
            .httpsPort(-1)
            .usingFilesUnderClasspath("example_stubs")
            .notifier(new Slf4jNotifier(true))
            .disableRequestJournal()); /*.extensions() ResponseDefinitionTransformer*/
    }
}
