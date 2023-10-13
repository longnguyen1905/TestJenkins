Feature: Withdraw MYR

  Background:
    Given User logged in to lobby
    And user added an exits MYR Bank account information


  Scenario: valid amount
    Given user navigate to profile page
    And user select MYR
    When user input amount "10" MYR
    Then button withdraw is enable


  Scenario: empty amount
    Given user navigate to profile page
    And user select MYR
    When user input amount "" MYR
    Then button withdraw is disable
    And input amount MYR field is empty


  Scenario: invalid amount
    Given user navigate to profile page
    And user select MYR
    When user input amount "This!@#" MYR
    Then button withdraw is disable
    And input amount MYR field is empty


  Scenario: input amount greater than balance
    Given user navigate to profile page
    And user select MYR
    When user input amount "9999" MYR
    Then button withdraw is disable



  Scenario: withdraw  success
    Given user navigate to profile page
    And user select MYR
    When user input amount "10" MYR
    And user click withdraw
    And user click withdraw on confirm popup
    Then pop up Withdraw successfully display
    And display new transaction history MYR
    And balance decrease "10" MYR


  Scenario: cancel withdraw
    Given user navigate to profile page
    And user select MYR
    When user input amount "10" MYR
    And user click withdraw
    And user click cancel on confirm popup
    Then withdraw MYR process stop