Feature: Read Table

  Scenario: Verify the addition operation for integer second
    Given I have created a calculator instance
    When I send following numbers
      | Number1 | Number2 | Operator |
      | 2       | 3       | +        |
      | 10      | 2       | _        |
      | 2       | 3       | *        |
      | 10      | 3       | /        |
    Then I get following result
      | ExpectedResult |
      | 6              |
      | 5              |
      | 5              |
      | 7              |