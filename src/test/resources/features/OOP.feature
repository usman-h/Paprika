Feature: This is the feature file for the session on Design Patterns

  @usman
  Scenario: First basic Scenario
    Given I am on the Direct Line homepage
    When I click on the motor quote button
    And After submitting my car details
    Then I should be taken to the 'About You' page

  @hussain
  Scenario: Second refactored Scenario
    Given I am on the Direct Line homepage
    When I click on the motor quote button
    Then I can verify all the fields are present