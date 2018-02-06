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

  @usman1
  Scenario: Login test 1
    Given I am on the login page
    When I am on the login page
    When i successfully login
    Then i should see the next page

  @usman2
  Scenario: Login test 2
    Given I am on the login page
    And I enter in the username
    And i enter in the password
    When i click on the login button
    Then i should be logged in

  @usman3
  Scenario: Login test 3
    Given I am on the login page
    When blah blah blhab
    Then I should be taken to the 'About You' page

