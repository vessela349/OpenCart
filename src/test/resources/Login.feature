@allLoginTests
Feature: Logging into the system
  As a customer,
  I want to be able to log into the system,
  so that all my data is saved

  @positiveLoginTest
  Scenario: Log in with correct email and password
    Given the user is on the login page
    When he enters a correct email "testing@example.com" and password "Testing123" and logs in
    Then he should be logged in


  @negativeLoginTestInvalidEmail
  Scenario: Log in with invalid email format and password
    Given the user is on the login page
    When he enters a wrong email "blahblah" and password "PWPWPW" and tries to log in
    Then error message should appear

  @negativeLoginTestWrongEmail
  Scenario: Log in with wrong email and password
    Given the user is on the login page
    When he enters a wrong email "testin@example.com" and password "Testing123" and tries to log in
    Then error message should appear

  @negativeLoginTestWrongPasswordLowercase
  Scenario: Log in with correct email and wrong password - lowercase letters
    Given the user is on the login page
    When he enters a wrong email "testing@example.com" and password "testing123" and tries to log in
    Then error message should appear

  @negativeLoginTestWrongPassword
  Scenario: Log in with correct email and wrong password
    Given the user is on the login page
    When he enters a wrong email "testing@example.com" and password "49238409" and tries to log in
    Then error message should appear