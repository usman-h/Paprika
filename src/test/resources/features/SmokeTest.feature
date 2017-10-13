@smoketest
Feature: This is a smoke test to verify tests can be executed or not

  Scenario Outline: Simple search test
    Given I have navigated to a website
    When I search for the following '<searchTerm>'
    Then The correct <searchTerm> appears on the screen
    Examples:
      | searchTerm |
      | Car        |
      | Train      |
