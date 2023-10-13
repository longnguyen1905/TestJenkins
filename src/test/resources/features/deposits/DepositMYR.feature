Feature: Deposit with MYR wallet

  Background:
    Given User logged in to lobby


  Scenario: user does not select bank account
    Given user select MYR
    And user stays at deposit page
    When user does not select bank
    Then button deposit is disable
    And user switch back to TON wallet


  Scenario: input amount < 10000 MYR
    Given user select MYR
    And user stays at deposit page
    And user select a bank account
    When user input "9.9999" MYR
    Then button deposit is disable
    And user switch back to TON wallet


  Scenario: input amount > 10000 MYR
    Given user select MYR
    And user stays at deposit page
    And user select a bank account
    When user input "10000.01" MYR
    Then button deposit is disable
    And user should see error message "Please enter a smaller number 10000"
    And user switch back to TON wallet


  Scenario: input amount 10 - allow to deposit
    Given user select MYR
    And user stays at deposit page
    And user select a bank account
    When user input "10" MYR
    Then button deposit is enable
    And user switch back to TON wallet


  Scenario: input amount 10000 - allow to deposit
    Given user select MYR
    And user stays at deposit page
    And user select a bank account
    When user input "10000" MYR
    Then button deposit is enable
    And user switch back to TON wallet