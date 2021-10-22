package com.example.component.steps;

import com.example.component.ScenarioContext;
import com.example.component.actions.ExampleServiceActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Slf4j
public class ExampleServiceStepdefs {

    @Autowired
    private ExampleServiceActions exampleServiceActions;
    @Autowired
    private ScenarioContext scenarioContext;

    /*@Value("example-service.url")
    private int exampleServiceUrl;*/

    @Given("active user exists")
    public void activeUserExists() {
        System.out.println("Active user exists");
    }

    @When("user sends a valid get request")
    public void userSendsValidGetRequest() {
        final Response response = exampleServiceActions.sendGetRequest("/");
        scenarioContext.saveData("RESPONSE", response);
    }

    @Then("response has the following fields and values")
    public void responseWithFieldAndValues() {
        final Response response = (Response) scenarioContext.getData("RESPONSE");
        final String responseBody = response.getBody().asString();

        log.info("Response body received from example service {}", responseBody);

        assertThat("Correct response received", responseBody, containsString("my feedback"));
    }
}
