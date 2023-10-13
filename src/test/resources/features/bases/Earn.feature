Feature: Earn and Referral

  Background:
    Given User logged in to lobby


  Scenario: Referral code section
    Given user navigate to earn page
    When user observe Your referral section
    Then user can see referral code
    And user can see social button to share referral code


  Scenario: Telegram redirection
    Given user navigate to earn page
    When user click on telegram icon
    Then user will be redirected to telegram popup contains url

  @Test
  Scenario: Facebook redirection
    Given user navigate to earn page
    When user click on facebook icon
    Then user will be redirected to facebook popup contains url "lobby.tpotslotty.cc?start"



