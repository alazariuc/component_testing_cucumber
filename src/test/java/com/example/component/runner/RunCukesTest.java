package com.example.component.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    tags = "not @Ignore",
    features = "src/test/resources/features",
    glue = "com.example.component",
    plugin = "pretty",
    stepNotifications = true
)
public class RunCukesTest {
}
