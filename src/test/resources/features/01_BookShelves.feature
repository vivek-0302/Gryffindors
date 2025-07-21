#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Urban Ladder shopping and filtering experience
 
  As a user of the Urban Ladder website
  I want to browse, filter, and purchase items
  So that I can find products that match my preferences
 
  
  Scenario: Filter bookshelves by storage type, price, and availability
    Given I open the Urban Ladder website
    And I navigate to the "Living" section
    When I click on the "Bookshelves" category
    And I close the popup modal if it appears
    And I apply the "Open" storage type filter
    And I adjust the price range using the slider
    And I select the "In Stock Only" checkbox
    Then I should see the top 3 bookshelves displayed with their names and prices