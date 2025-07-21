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
Feature: Filter and display showcase items on Urban Ladder
 
  Scenario: User filters showcases by closed storage type and excludes out-of-stock items
    Given the user is on the Urban Ladder homepage
    When the user hovers over the "Living" menu
    And the user clicks on "Showcases"
    And the user selects "Closed" under storage type filter
    And the user excludes out-of-stock items
    Then the user should see the names and prices of the top 3 showcase items