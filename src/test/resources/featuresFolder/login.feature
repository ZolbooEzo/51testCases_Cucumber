Feature: Login test

	Background:
	Given User is on home page
	When User clicks on myaccout link
    
 	  Scenario: Valid username and password1
    And Login with valid credentials
    Then Verify dashboard link is displayed
    
    Scenario: Incorrect username and incorrect password2
    And Login with false username and password
    Then Verify not registered error message


		Scenario: Correct user name and empty password3
    And Login with valid username and empty password
    Then Verify password is required error message
    
		Scenario: Empty user name and valid password4
		And Login with empty password and valid password
		Then Verify user name required error
		
		Scenario: Empty user name and empty password5
		And Login with empty user name and empty password
		Then Verify user name required error
		
		Scenario: Validate password is musked6
		And Enter password in password box field
		Then Verify password is masked
		
		Scenario: Validate login function hadles case sensitivity7
		And Enter user name and password all lower case
		Then Verify lost your password error is displayed
		
		Scenario: Validate authentication8
		And Login with valid credentials
		And click signout
		And hit back button
		Then Verify user is on my account page
		
	