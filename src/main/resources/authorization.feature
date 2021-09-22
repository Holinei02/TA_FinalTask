Feature: Authorization
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check registration availability
    Given User opens '<registerPage>' authorization page
    When User checks email and password fields visibility
    Then User checks first and last name fields visibility

    Examples:
      | registerPage                          |
      | https://my.asos.com/identity/register |

  Scenario Outline: Check registration without any data entering
    Given User opens '<registerPage>' authorization page
    And User checks 'Submit' button visibility
    When User clicks 'Submit' button
    Then User checks validation error messages are visible

    Examples:
      | registerPage                          |
      | https://my.asos.com/identity/register |

  Scenario Outline: Check social registration
    Given User opens '<registerPage>' authorization page
    And User checks 'Sign up with Google' button visibility
    When User clicks 'Sign up with Google' button
    Then User checks that google account redirection opens

    Examples:
      | registerPage                          |
      | https://my.asos.com/identity/register |

  Scenario Outline: Check signing in
    Given User opens '<signInPage>' login page
    And User checks email and password fields visibility in SignIn page
    When User enters email '<email>' in the appropriate field
    And User enters password '<password>'
    And User clicks 'Sign In' button
    Then User checks validation error message is displayed

    Examples:
      | signInPage                         | email            |password |
      | https://my.asos.com/identity/login | example@gmail.com|qwerty123|