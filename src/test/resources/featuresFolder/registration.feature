
Feature: Title of your feature

Background:
Given User is on home page
When User clicks on myaccout link

  Scenario: User creates new account
    When User creates new account with username and password
    Then Verify account is created and on dashboard page
    
    @unit
    Scenario: User creates new account
    When User enter invalid email and valid password in registration window
    Then Validate please provide valid email error displayed

