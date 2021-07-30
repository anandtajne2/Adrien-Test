Feature: Form Step

  Scenario: Form - Patient App Web - Basic
    Given Patient navigate to activity list as "user.provided@medable.com"
    And Patient select Form Step Task on activity list page
    And Patient should see Form Step Task task ready to start
    And Patient completes Form Step with values
      | Type                  | Value              |
      | Email Step            | a@a.com            |
      | Text Step             | Automation         |
      | Numeric Step          |                 21 |
      | Value Picker Step     | Option 1           |
      | Boolean Step          | True               |
      | Continuous Scale Step |                5.5 |
      | Integer Scale Step    |                  5 |
      | Location Step         | Cordoba, Argentina |
      | Text Scale Step       |                  1 |
      | Time Interval Step    | 2 2                |
      | Time of Day Step      | 1 1 PM             |
    And Patient click next button is step page
    And Patient click skip button in step page
    And Patient should see the completion step page
    And Patient click done button in step page
    Then Patient should see the Activity list page
    And Patient should see Form Step Task completed
