Feature: patient login

  Scenario: user login
    Given Patient navigate to the welcome study page
    When Patient click on I have an accound button in welcome page
    And Patient should see the login page
    And Patient enter the email "user.provided@medable.com" in login page
    And Patient enter the password "qpal1010" in login page
    And Patient click login button in login page
    Then Patient navigate to the activity list page
