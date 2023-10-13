Feature: Tournament

  Background:
    Given User logged in to lobby


  Scenario: Switch currency TON
    Given user select TON
    When user navigate tournament page
    Then user must not see any currencies except TON


  Scenario: Switch currency MYR
    Given user select MYR
    When user navigate tournament page
    Then user must not see any currencies except MYR
    And user switch back to TON wallet


  Scenario: Switch currency VND
    Given user select VND
    When user navigate tournament page
    Then user must not see any currencies except VND
    And user switch back to TON wallet


  Scenario: Tournament header
    Given user navigate tournament page
    When user select TON
    Then user see payout section "Paid out prize in 30 days"


  Scenario: Tournament dropdown list
    Given user navigate tournament page
    When user click tournament dropdown list
    Then user can see the dropdown list options


  Scenario: Tournament dropdown list - daily tournaments
    Given user navigate tournament page
    When user click tournament dropdown list
    And user click Daily
    Then user only see daily tournaments


  Scenario: Tournament dropdown list - weekly tournaments
    Given user navigate tournament page
    When user click tournament dropdown list
    And user click Weekly
    Then user only see weekly tournaments


  Scenario: Tournament dropdown list - monthly tournaments
    Given user navigate tournament page
    When user click tournament dropdown list
    And user click Monthly
    Then user only see monthly tournaments


  Scenario: Tournament details from banner
    Given user navigate tournament page
    When user click exclamation mark icon on banner
    Then user can see tournament details

  Scenario: Tournament information
    Given user navigate tournament page
    When user click exclamation mark icon of first tournament
    Then user can see information tournament detail

  Scenario: Tournament prize pool
    Given user navigate tournament page
    When user click exclamation mark icon of first tournament
    Then user can see prize pool tournament detail

  Scenario: Tournament leader board
    Given user navigate tournament page
    When user click exclamation mark icon of first tournament
    Then user can see leader board tournament detail