@allTestsForAddingiMac
Feature: Adding item to cart
  As a customer,
  I want to be able to add items to my cart,
  so that I can buy them.

  @addToCartTest
  Scenario: Add iMac to cart
    Given the user is on the iMac product details page
    When he selects to add iMac to cart
    Then he should receive a success message

  Scenario: Add Apple Cinema 30 to cart
    Given the user is on the Apple Cinema product details page
    When he selects all necessary configurations
    And he selects to add Apple Cinema to cart
    Then he should receive a success message