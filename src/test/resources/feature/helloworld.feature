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
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag
  Scenario Outline: Validate Title
    Given I have <browser> open
    When I go to "<url>"
    Then the title of the webpage should be "<title>"
    Then the page should contain "Log in" link text
    Then when i scroll the page 

    Examples: 
      | browser | url                                      	| title                  |
      | chrome  | https://en.wikipedia.org/wiki/Darjeeling 	| Darjeeling - Wikipedia |
#      | chrome  | https://en.wikipedia.org/wiki/Bangalore 	| Bangalore - Wikipedia |
#      | firefox | https://en.wikipedia.org/wiki/Darjeeling | Darjeeling - Wikipedia |

#
# @tag
#  Scenario Outline: This is different Scenario
#    Given I have <browser> open
#    When I go to "<url>"
#    Then the title of the webpage should be "<title>"
#    Then the page should contain "Log in" link text
#    Then when i scroll the page 
#
#    Examples: 
#      | browser | url                                      	| title                  |
#      | chrome  | https://en.wikipedia.org/wiki/Darjeeling 	| Darjeeling - Wikipedia |
##      | chrome  | https://en.wikipedia.org/wiki/Bangalore 	| Bangalore - Wikipedia |
##      | firefox | https://en.wikipedia.org/wiki/Darjeeling | Darjeeling - Wikipedia |
