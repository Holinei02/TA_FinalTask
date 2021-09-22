Feature: Smoke
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

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart popup visible
    And User checks 'Continue Shopping' button visibility
    And User checks 'Continue to Cart' button visibility
    Then User checks that add to cart popup header is '<header>'
    And User clicks 'Continue to Cart' button
    And User clicks 'Checkout' button
    And User clicks payment cart button
    And User checks payment form visibility
    And User checks billing form visibility
    And User checks 'Complete Order' button visibility

    Examples:
      | homePage                            | keyword  | header                                |
      | https://www.canadiantire.ca/en.html | 0830032p | You have added 1 item(s) to your cart |

