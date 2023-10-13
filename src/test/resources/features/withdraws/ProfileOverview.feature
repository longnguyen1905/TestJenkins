Feature: Profile overview

  Background:
    Given User logged in to lobby
    And user added an exits TON address


  Scenario: User information
    Given user navigate to profile page
    When user observe account section
    Then user can see account information details


  Scenario: Auto withdraw section
    Given user navigate to profile page
    When user observe withdraw section
    Then user can see withdraw information details


  Scenario: Wallet address section
    Given user navigate to profile page
    When user observe wallet address section
    Then user can see wallet address information


  Scenario: Transactions history
    Given user navigate to profile page
    When user observe Transactions
    Then user can see Transactions details


  Scenario: Edit wallet address
    Given user navigate to profile page
    When user click on Edit
    Then Edit button disable, Save button enable
    And user can edit the wallet address
#    should edit to old address again, after edit new address


  Scenario: Cancel edit wallet address
    Given user navigate to profile page
    When user click on Edit
    And user edit the address without saving
    Then Edit button enable, Save button disable
    And wallet address was not changed


#  Scenario: User can auto withdraw
#    Given user navigate to profile page
#    And user click on Auto withdraw toggle
#    Then auto withdraw enable
#    And user able to turn off withdraw toggle