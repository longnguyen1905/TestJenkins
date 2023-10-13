Feature: Deposit Overview (TON)

  Background:
    Given User logged in to lobby


  Scenario: user can switch between Deposit or Buy Crypto tab
    Given user stays at deposit page
    And user click on Buy Crypto
#      Then user can see Buy Crypto tab
    And user can switch back to Deposit tab


  Scenario: user can see deposit section details
    Given user stays at deposit page
    And user observe deposit section
    Then user can see deposit section details


  Scenario: user can select amount by default
    Given user stays at deposit page
    When user can click on pack of amount
      | amount |
      | 5      |
      | 10     |
      | 20     |
      | 50     |
      | 100    |
      | 150    |
      | 200    |
      | 250    |
    Then user can see input amount change


  Scenario: user can select payment methods
    Given user stays at deposit page
    When user click on QR Code
    Then user can will be able to click on Ton Keeper or Ton Hub
    And user can see wallet's icons


  Scenario: user can see QR code details
    Given user stays at deposit page
    When user click on QR Code
    Then user will see QR code details
    And user can see wallet's icons
    And user can tap Ton address to copy
#    verify "copy" display, "tap Ton address to copy" invisible

