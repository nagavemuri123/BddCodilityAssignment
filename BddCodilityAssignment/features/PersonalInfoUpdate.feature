Feature: Update Personal information

  Scenario: Update first name of a user
    Given I am on automationpractice website as login user
    When I navigate to Personal information page
    And I update the first name of the user
    Then I shuold see the "Your personal information has been successfully updated." message
