Feature: MainPage
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks cart visibility
    And User checks 'My account' button visibility
    When User clicks 'My account' button
    And User checks register button visibility
    And User checks sign in button visibility
    And User closes sign in popup
    And User opens shopping bag
    And User checks that current url contains 'bag' word
    And User clicks country button
    Then User checks that country and currency selectors are visible

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |


