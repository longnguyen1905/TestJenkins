Feature: Home page

  Background:

    Given User logged in to lobby

  Scenario: user can see banner
    Given user stayed at homepage
    When user scroll begin page
    Then user can see banner

  Scenario: user can play first game
    Given user stayed at homepage
    When user click first game
    Then user can play first game
#@UpdateLater
#  Scenario: user can play any game
#    Given user stayed at homepage
#    When user choose one game
#    Then user can play any game