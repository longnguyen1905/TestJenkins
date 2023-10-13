Feature: Login without referral

  Background:

    Given user is not logged in lobby.


  Scenario: Log in with Mail OTP - Valid email
    Given user click on Login
    And user click Continue with mail OTP
    When user enter the email "longuyen@alphanetworks.global"
    And user click Send
    Then user can see pop up input OTP


  Scenario:    Log in with Mail OTP - Invalid email
    Given user click on Login
    And user click Continue with mail OTP
    When user enter email "longnguyen"
    And user click Send
    Then user can see error message "Email is invalid"
    And Send button is disable


  Scenario: Log in with Mail OTP - Wrong format email
    Given user click on Login
    And user click Continue with mail OTP
    When user enter email "testmail@.mail.c"
    And user click Send
    Then user can see pop up error message "Something wasn't right. please try again"


  Scenario: Log in with Mail OTP - Empty email
    Given user click on Login
    And user click Continue with mail OTP
    When user leave blank email ""
    Then user cannot send email
    And Send button is disable



#  Scenario:   Log in with Mail OTP - Valid OTP
#
#    Given user click on Login
#    And user click Continue with mail OTP
#    And user enter the email "longuyen@alphanetworks.global"
#    When user input valid OTP
#    And user click log in
#    Then user can see pop up input username

#  Scenario:   Log in with Mail OTP - Valid OTP – old account
#    Given user click on Login
#    And user click Continue with mail OTP
#    And user enter email existed ""
#    When user input valid OTP
#    And user click log in
#    Then user navigate to lobby


  Scenario: Log in with Mail OTP - Invalid OTP
    Given user click on Login
    And user click Continue with mail OTP
    And user enter the email "longuyen@alphanetworks.global"
    When user input OTP "123456"
    And user click log in
    Then user can see email error message "OTP code is invalid"


  Scenario: Log in with Mail OTP - Empty OTP
    Given user click on Login
    And user click Continue with mail OTP
    And user enter the email "longuyen@alphanetworks.global"
    When user leave blank OTP
    Then log in button is disable


  Scenario: Log in with Mail OTP - Resend status disable within 60 sec
    Given user click on Login
    And user click Continue with mail OTP
    And user enter the email "longuyen@alphanetworks.global"
    Then countdown time is displayed


#  Scenario: Log in with Mail OTP - Resend status enable after 60 sec
#    Given user click on Login
#    And user click Continue with mail OTP
#    And user enter the email "longuyen@alphanetworks.global"
#    When user wait for 60 sec
#    Then resend is enable
#    And countdown time is invisible
#  Scenario:   Log in with Mail OTP - First name empty
#    Given user click on Login
#    And user complete enter email and OTP
#    When user leave blank First name ""
#    Then Save changes button is disable
#
#
#
#  Scenario:   Log in with Mail OTP - First name have data
#    Given user click on Log in
#    And user complete enter email and OTP
#    When input First name "Tai"
#    Then Save changes button is enable
#    And user click Save change
#    And user login success



#  Scenario:   Log in with Telegram
#    Given user click on Login
#    When user click Open telegram app
#    Then user navigate to telegram url
#    And user should see popup redirection to telegram


  Scenario:   Log in with Line
    Given user click on Login
    When user click Continue with Line
    Then user should see only one module login by Line
    And user navigate to URL line url that contains "lobby.tpotslotty.cc"