Feature: Deposit with Tonkeeper
  User use Ton keeper wallet to make deposit

  Background:
    Given User logged in to lobby


  Scenario:  TON Input normal
    Given user stays at deposit page
    When user input "0.01" TON
    Then button deposit is enable


  Scenario:  TON Input < Min (<0.01)
    Given user stays at deposit page
    When user input "0.0099" TON
    Then button deposit is disable


  Scenario:  TON Input > Max (>10000)
    Given user stays at deposit page
    When user input "10001" TON
    Then button deposit is disable
    And user should see error message "Please enter a smaller number 10000"


  Scenario:  TON Input invalid
    Given user stays at deposit page
    When user input "ZXCzxc@!#" TON
    Then button deposit is disable
    And user is not allowed to enter nun-numeric value


  Scenario:  TON Input empty
    Given user stays at deposit page
    When user input "" TON
    Then button deposit is disable
    And user should see value ton input is empty


  Scenario: User can make deposit TON via TON keeper
    Given user stays at deposit page
    When user input "0.01" TON
    And user click Deposit button
    Then user will be redirected to URL begin "https://app.tonkeeper.com/transfer/"
    And user can make a payment