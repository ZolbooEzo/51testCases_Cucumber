Feature: Registration Test

Background:
Given User is on home page
When User clicks on myaccout link

  Scenario: User creates new account1
    When User creates new account with username and password
    Then Verify account is created and on dashboard page
    

    Scenario: Enter invalid email and valid password2
    When User enter invalid email and valid password in registration fields
    Then Validate please provide valid email error displayed

		Scenario: Enter empty email in registration and valid password3
    When User enter empty email and valid password in registration fields
    Then Validate please provide valid email error displayed

    Scenario: Enter valid email in registration and empty password4
    When User enter valid email and empty password in registration fields
    Then Validate please enter password error displayed
  
    Scenario: Enter empty email and empty password in registration5
    When User enter empty email and empty password in registration fields
    Then Validate please provide valid email error displayed
    
    