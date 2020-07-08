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
#@tag
#Feature: Feature to test RestAPI
#
  #@tag
  #Scenario Outline: To make a simple call to REST API and validate the status code
    #Given I mandatory headers are set
    #Then I make a GET call to "URI"
    #Then i should get 200 response code
    #And the response jsonpath "<jsonpath>" should contain "<Value>"
#
    #Examples: 
      #| URI                                | jsonpath | Value |
      #| https://reqres.in/api/users?page=2 | $[0].id  |     1 |
