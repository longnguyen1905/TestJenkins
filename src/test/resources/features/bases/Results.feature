Feature: Results

  Background:

    Given User logged in to lobby


  Scenario: user can see all results
    Given user stayed at homepage
    When user click on results page
    Then user can see all results


  Scenario: user can see details first results
    Given user stayed at homepage
    When user click on results page
    And user click first tournament
    Then user can see detail first results


  Scenario: user can see detail results
    Given user stayed at homepage
    When user click on results page
    Then user can see each detail results tournament