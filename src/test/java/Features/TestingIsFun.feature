@Web
Feature:Bs demo site
  As a user of Bs demo site ,I should log in


  Scenario: Verify login feature
    Given I am on BS demo website
    When I click on 'Sign In' link
    And I enter following credentials
      | username | password       |
      | demouser | testingisfun99 |
    And I click on Login button
    Then I am successfully logged in


  Scenario Outline: Verify Multiple users
    Given I am on BS demo website
    When I click on 'Sign In' link
    And I enter '<username>' and '<password>' credentials
    And I click on Login button
    Then I verified '<username>' successfully logged in
    Examples:
      | username               | password       |
      | demouser               | testingisfun99 |
      | image_not_loading_user | testingisfun99 |
      | existing_orders_user   | testingisfun99 |
      | fav_user               | testingisfun99 |
      | locked_user            | testingisfun99 |


