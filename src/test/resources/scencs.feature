
Feature: Detecting searching result
  Description: This function will check the action that the particular text is looking for and number of searching result

  Background: User got searching result
    Given User navigates to the google page
    When User submit searching word
    Then Result page should be shown

  Scenario: Navigate first link and find specific text in the title
    Given User is on result page
    When User is searching specific link on results pages
    And User is searching number of results
    Then detected result page
