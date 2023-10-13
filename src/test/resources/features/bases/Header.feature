Feature: Homepage header
  Background:
    Given User logged in to lobby


  Scenario: user can navigate to tournament page
    Given user stayed at homepage
    When user click on tournaments
    Then user will be redirected to tournament page
    And user can see the running tournaments


  Scenario: user can navigate to results page
    Given user stayed at homepage
    When user click on results
    Then user will be redirected to results page
    And user can see the ending tournaments


  Scenario: user can navigate to upcoming page
    Given user stayed at homepage
    When user click on upcoming
    Then user will be redirected to upcoming page
    And user can see the upcoming tournaments


  Scenario: user can navigate to earn page
    Given user stayed at homepage
    When user click on earn
    Then user will be redirected to earn page
    And user can see the referral section


  Scenario: user can navigate to deposit page
    Given user stayed at homepage
    When user click on deposit
    Then user will be redirected to deposit page
    And user can see the deposit section


  Scenario: user can navigate to search page
    Given user stayed at homepage
    When user click on search header
    Then user will be redirected to search page
    And user can see the search section


  Scenario: user can navigate to profile page
    Given user stayed at homepage
    When user click on profile
    Then user will be redirected to profile page
    And user can see the profile player


  Scenario: user can navigate to term and condition page
    Given user stayed at homepage
    When user click on term and condition
    Then user will be redirected to term and condition page


  Scenario: user can see footer
    Given user stayed at homepage
    When user scroll end of page
    Then user can see footer
