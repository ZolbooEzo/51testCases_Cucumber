Feature: My Account Test

Background:
	Given User is on home page
	When User clicks on myaccout link
	
  Scenario: Check dashbaord link1
  	And Login with valid credentials
    Then Verify dashboard link is displayed

  Scenario: Check view order link2
  	And Login with valid credentials
  	And User clicks on order link 
  	And User clicks on view link
    Then Verify order details text is displayed
    
  Scenario: Check view order link details3
    And Login with valid credentials
  	And User clicks on order link 
  	And User clicks on view link
    Then Verify Order details customer details and billing details
    
  Scenario: check status date details4
    And Login with valid credentials
  	And User clicks on order link 
  	And User clicks on view link
    Then Verify orderNumberText orderDateText and orderStatusText
   
  Scenario: address functionality check5
    And Login with valid credentials
    And User clicks on address link
    Then Verify billing address and shipping address
    
  Scenario: Edit shipping address check6
    And Login with valid credentials
    And User clicks on address link
    And User clicks on shipping address edit button
    Then Verify shipping address save button is displayed
   
  Scenario: account details function check7
    And Login with valid credentials
    And User clicks on account details link
    Then Verify change password options is displayed
    
  Scenario: Logout check8
    And Login with valid credentials
    And User clicks logout Link
    Then Verify if user is landed on login page
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    