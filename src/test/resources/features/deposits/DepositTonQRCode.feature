Feature: Deposit with QR CODE
  User use Ton keeper wallet to make deposit

  Background:
    Given User logged in to lobby


  Scenario:  TON Input normal
    Given user stays at deposit page
    And user select QR code
    When user input "0.01" TON
    Then QR code is visible


  Scenario:  TON Input < Min (<0.01)
    Given user stays at deposit page
    And user select QR code
    When user input "0.0099" TON
    Then QR code is invisible


  Scenario:  TON Input > Max (>10000)
    Given user stays at deposit page
    And user select QR code
    When user input "10001" TON
    Then user should see error message "Please enter a smaller number 10000"


  Scenario:  TON Input invalid
    Given user stays at deposit page
    And user select QR code
    When user input "ZXCzxc@!#" TON
    Then QR code is invisible
    And user is not allowed to enter nun-numeric value


  Scenario:  TON Input empty
    Given user stays at deposit page
    And user select QR code
    When user input "" TON
    Then QR code is invisible



