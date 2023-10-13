Feature: Withdraw TON

  Background:
    Given User logged in to lobby
    And user added an exits TON address


  Scenario: valid amount - withdraw success
    Given user navigate to profile page
    When user input amount "0.01" TON
    And user click withdraw
    And user click withdraw on confirm popup
    Then pop up Withdraw successfully display
    And display new transaction history
    And balance decrease "0.01" TON


  Scenario: cancel withdraw
    Given user navigate to profile page
    When user input amount "0.01" TON
    And user click withdraw
    And user click cancel on confirm popup
    Then withdraw process stop


  Scenario: invalid amount
    Given user navigate to profile page
    When user input amount "ZXCzxc!@#" TON
    Then input amount field is empty
    And button withdraw is disable


  Scenario: empty amount
    Given user navigate to profile page
    When user input amount "" TON
    Then button withdraw is disable
    And input amount field is empty


  Scenario: amount < 0.01
    Given user navigate to profile page
    When user input amount "0.0099" TON
    Then button withdraw is disable


  Scenario: amount > balance
    Given user navigate to profile page
    When user input amount "10" TON
    Then button withdraw is disable



