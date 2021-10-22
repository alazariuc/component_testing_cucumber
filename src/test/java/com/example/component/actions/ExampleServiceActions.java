package com.example.component.actions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceActions {

    public Response sendGetRequest(final String endpoint) {
        return RestAssured.given()
            .get(endpoint);
    }
}
