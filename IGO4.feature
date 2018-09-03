Feature: Base script for Web quote & Buy journey in IGO4

  @IGO4_wip
  Scenario Outline:
  This scenario is to create a quote using Money super market Aggregator for Motor

    Given I launch the <application> URL for <brand>
    And   I click on get a quote to fill the vehicle info and Policy holder details


    Examples:
      |application       |brand    |
      |IGO4              |Motor    |