Feature: Calculator Operations
  As a user I should able to do basic operations on calculator

  @Smoke
  Scenario Outline:Verify the addition operations on many data rows
    Given I have created calculator instance
    When I send <number1> and <number2> to function
    And I send '<operator>'
    Then I get <expectedResult> as result
    Examples:
      | number1 | number2 | operator | expectedResult |
      | 4       | 5       | +        | 9              |
      | 10      | 5       | -        | 5              |
      | 6       | 7       | *        | 42             |
      | 32      | 7       | /        | 4              |
  @table
  Scenario: Verify the addition on data
    Given I have created calculator instance
    When I send following numbers
      | Number1 | Number2 | Operator |
      | 2       | 3       | *        |
      | 10      | 2       | /        |
      | 2       | 3       | +        |
      | 3       | 1       | -        |
    Then I get following result
      | ExpectedResult |
      | 6              |
      | 5              |
      | 5              |
      | 2              |




