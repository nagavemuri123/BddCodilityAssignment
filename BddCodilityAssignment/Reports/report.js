$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("OrderTShirt.feature");
formatter.feature({
  "line": 1,
  "name": "Order T-Shirt",
  "description": "",
  "id": "order-t-shirt",
  "keyword": "Feature"
});
formatter.uri("PersonalInfoUpdate.feature");
formatter.feature({
  "line": 1,
  "name": "Update Personal information",
  "description": "",
  "id": "update-personal-information",
  "keyword": "Feature"
});
formatter.before({
  "duration": 13178166538,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Update first name of a user",
  "description": "",
  "id": "update-personal-information;update-first-name-of-a-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on automationpractice website as login user",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I navigate to Personal information page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I update the first name of the user",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I shuold see the \"Your personal information has been successfully updated.\" message",
  "keyword": "Then "
});
formatter.match({
  "location": "AutomationPracticeStepDef.I_am_on_automationpractice_website_as_login_user()"
});
});