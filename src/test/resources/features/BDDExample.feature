@usman4
Feature: Creation of policy
  As a business owner
  I want to cereate this application
  So that i am able to create a policy

#  Background:
#    Given step 1
#    And step 2
#
#  Scenario: a scenario
#    When I do step 3
#    Then it works
#
#  Scenario: another scenario
#    When I do a different step 3
#    Then it works
#
#  Scenario:  yet another scenario
#    When I do a different step 3
#    And step 4
#    Then it works


  Scenario: Search 1
    Given i am on google
    When i search for cars
    Then I see the correct cars results

  Scenario: Search 2
    Given i am on google
    When i search for trains
    Then I see the correct trains results

  Scenario: Search 3
    Given i am on google
    When i search for planes
    Then I see the correct planes results

  @usman5
  Scenario Outline: example
    Given i am on google
    When i search for <Transport>
    Then I see the correct <Transport> results
    Examples:
    | Transport |
    | cars      |
    | trains    |
    | planes    |


