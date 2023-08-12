Feature: Bs demo site
  @Web
  Scenario: Verify buying a product
    Given I am signed in with following credentials:
      | username | password       |
      | demouser | testingisfun99 |
    When I click on 'Add to Cart' on a product with name 'iPhone XR'
    And I click on checkout
    And I enter shipping address as below:
      | FirstName | LastName | Address | State | Pin   |
      | Sandeep   | Garud    | Pune    | MH    | 41027 |
    And I click on Submit button
    Then I see a message 'Your Order has been successfully placed.'
    And I see the product 'iPhone XR' on final page right hand side