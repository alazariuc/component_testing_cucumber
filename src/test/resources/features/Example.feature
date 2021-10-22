Feature: Example service

  Scenario: Get example service request
    Given active user exists
    When user sends a valid get request
    Then response has the following fields and values