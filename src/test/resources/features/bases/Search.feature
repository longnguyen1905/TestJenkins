Feature: Search

  Background:

    Given User logged in to lobby

  Scenario: close search by button exit
    Given user stayed at search page
    When user click on search exit
    Then user can see home page

  Scenario: close search by search header
    Given user stayed at search page
    When user click on search header
    Then user can see home page

  Scenario: user leave blank input search
    Given user stayed at search page
    When user click on search
    Then user can see search input blank

  Scenario: default search all game publisher
    Given user stayed at search page
    When user click on search
    Then user can see game publisher all

  Scenario: dropdown list game publisher
    Given user stayed at search page
    When user click on dropdown list
    Then user can see list publisher

  Scenario: search by PGSoft
    Given user stayed at search page
    When user select PGSoft
    Then user can see list game PGSoft

  Scenario: search by Pragmatic
    Given user stayed at search page
    When user select Pragmatic
    Then user can see list game Pragmatic

  Scenario: valid game
    Given user stayed at search page
    When user input search key search
      | keySearch |
      | Dra       |
      | return    |
      | RI        |
      | CrY       |
      | ll        |
    Then user can see list game results

  Scenario: no results
    Given user stayed at search page
    When user input search "Dra123"
    Then user see results do not any game