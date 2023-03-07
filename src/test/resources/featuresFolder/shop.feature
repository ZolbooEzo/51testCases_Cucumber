
Feature: Shop Test

Background:
Given User is on home page

  Scenario: Filter by price functionality1
    When User clicks on shop menu
    And User adjust the filter by price between 150 to 450 rps
    And User clicks on filter button
    Then Verify books priced 150 to 450 only
    
  Scenario: Categories Functionality2
    When User clicks on shop menu
		And User clicks on html link
		Then Verify link contains only html related books
		
	Scenario: checking popular options3
    When User clicks on shop menu
    And User chooses popular on drop down options
    Then Verify user can see popular products only
    
  Scenario: checking average drop down options4
    When User clicks on shop menu
    And User chooses average on drop down options
    Then Verify user can see popular products only
    
	Scenario: checking average drop down options5
    When User clicks on shop menu
    And User chooses date on drop down options
    Then Verify user can see popular products only
   
  Scenario: checking average drop down options6
    When User clicks on shop menu
    And User chooses prices on drop down options
    Then Verify user can see popular products only
    
  Scenario: Read more functionality7
    When User clicks on shop menu
    And User clicks on read more button
    Then Verify out of stock label
    
  Scenario: Sale functionality8
    When User clicks on shop menu
    And User scroll by 400
    And User clicks on sale written product
    Then Verify product has both old and new price
    
  Scenario: Basket functionality9
    When User clicks on javascript book image
    And User refreshes the page
    When User clicks on javascript book image
    And User clicks on add to basket
    And User clicks on cart link in menu
    Then Veify total is higher than subtotal
    And User scroll by 400
    And User clicks on proceed to checkout
    Then Verify billing details additional details and your order info is displayed
    And Fills all info at checkout page
    And User scroll by 900
    And User clicks on place order button
    Then Verify order confirmation number is dislplayed
    
    
    
    
    
    
    
    
    
    
    
    
    