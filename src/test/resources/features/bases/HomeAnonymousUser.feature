Feature: Home page anonymous user

  Background:

    Given user is not logged in lobby.

  Scenario: user can see banner
    Given user stayed at homepage
    When user scroll to begin page
    Then user can see banner


  Scenario: user need login to play game
    Given user stayed at homepage
    When user click on open game
    Then user can see pop up please login


  Scenario: user can not played game by image game
    Given user stayed at homepage
    When user click on image game
    Then user can see two button deposit and open game

  Scenario: redirect to wallet
    Given user stayed at homepage
    When user click on deposit button
    Then user can see wallet section


  Scenario: back to home page
    Given user stayed at homepage
    When user click on open game
    And user click on continue
    Then user back to home page


  Scenario: redirect to login
    Given user stayed at homepage
    When user click on open game
    And user click on login
    Then user can see popup login


  Scenario: user not allow to profile page
    Given user stayed at homepage
    When user click on profile
    Then user can see pop up please login


  Scenario: user not allow to earn page
    Given user stayed at homepage
    When user click on earn
    Then user can see pop up please login