$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/CreateUser.feature");
formatter.feature({
  "name": "Create User",
  "description": "  User creating new account",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Opening new Account from the home page link",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@registration"
    }
  ]
});
formatter.step({
  "name": "Open Browser and launch the URL",
  "keyword": "Given "
});
formatter.step({
  "name": "User logged in by his credentials \"\u003cUsername\u003e\", \"\u003cPassword\u003e\", \"\u003cFirst_Name\u003e\", \"\u003cLast_Name\u003e\", \"\u003cAddress\u003e\", \"\u003cCity\u003e\", \"\u003cState\u003e\", \"\u003cZip_Code\u003e\", \"\u003cSSN\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on Home link",
  "keyword": "When "
});
formatter.step({
  "name": "User click on the Open New Account link on the home page",
  "keyword": "When "
});
formatter.step({
  "name": "Create an account by entering the values",
  "keyword": "And "
});
formatter.step({
  "name": "Message will be displayed as Your new account number: xxxxx capture the account number",
  "keyword": "Then "
});
formatter.step({
  "name": "Click on the Accounts Overview link and verify the created account number is displayed",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "First_Name",
        "Last_Name",
        "Address",
        "City",
        "State",
        "Zip_Code",
        "SSN"
      ]
    },
    {
      "cells": [
        "rohit1212",
        "123456",
        "Rohit",
        "kumar",
        "Notenplien",
        "Den Haag",
        "south Holland",
        "2555ZZ",
        "123456789"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Opening new Account from the home page link",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@registration"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Browser and launch the URL",
  "keyword": "Given "
});
formatter.match({
  "location": "Step_Definitions.open_Browser_and_launch_the_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logged in by his credentials \"rohit1212\", \"123456\", \"Rohit\", \"kumar\", \"Notenplien\", \"Den Haag\", \"south Holland\", \"2555ZZ\", \"123456789\"",
  "keyword": "And "
});
formatter.match({
  "location": "Step_Definitions.user_logged_in_by_his_credentials(String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Home link",
  "keyword": "When "
});
formatter.match({
  "location": "Step_Definitions.user_clicks_on_Home_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on the Open New Account link on the home page",
  "keyword": "When "
});
formatter.match({
  "location": "Step_Definitions.user_click_on_the_Open_New_Account_link_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create an account by entering the values",
  "keyword": "And "
});
formatter.match({
  "location": "Step_Definitions.create_an_account_by_entering_the_values()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Message will be displayed as Your new account number: xxxxx capture the account number",
  "keyword": "Then "
});
formatter.match({
  "location": "Step_Definitions.message_will_be_displayed_as_Your_new_account_number_xxxxx_capture_the_account_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the Accounts Overview link and verify the created account number is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "Step_Definitions.click_on_the_Accounts_Overview_link_and_verify_the_created_account_number_is_displayed()"
});
formatter.result({
  "status": "passed"
});
});