Feature: feature one

@test
Scenario: scenario one point one
  Given one
  When two
  Then three

@test1
Scenario: Launch a slow application 1
  Given I launch evo application
  When I click next
  Then I should see registration text field

@test1
Scenario: Launch a slow application 2
  Given I launch evo application
  When I click next
  And I wait
  Then I should see registration text field
  
Scenario:
