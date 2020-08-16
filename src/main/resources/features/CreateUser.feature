#Author: your.email@your.domain.com
Feature: Create User
  User creating new account

  @registration
  Scenario Outline: Create a user account by entering the values
    Given Open Browser and launch the URL
    When User click on Register button to create a new account
    And User enters data for all the required fields "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<phone>", "<SSN>", "<userName>", "<password>", "<confirm>"
    And User click on Register button under the registration form
    Then User should displayed the message Your account was created successfully. You are now logged in. "<loginConfirm>"
    And User should logout from the application
    Then User logged in by his credentials "<userName>", "<password>", "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<SSN>"

    Examples: 
      | firstName | lastName | address    | city     | state         | zipCode | phone      | SSN       | userName  | password | confirm | loginConfirm                                                  |
      | Rohit     | kumar    | Notenplien | Den Haag | south Holland | 2555ZZ  | 0684105405 | 123456789 | rohit12113 |   123456 |  123456 | Your account was created successfully. You are now logged in. |

  @homelink
  Scenario Outline: Writing the all links name present in the home page into the notepad
    Given Open Browser and launch the URL
    And User logged in by his credentials "<userName>", "<password>", "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<SSN>"
    When User clicks on Home link
    And User write all the name of links present in the notepad
    Then A new file should be created with name of alllinks.txt in the file folder

    Examples: 
      | userName  | password | firstName | lastName | address    | city     | state         | zipCode | SSN       |
      | rohit12113 |   123456 | Rohit     | kumar    | Notenplien | Den Haag | south Holland | 2555ZZ  | 123456789 |

  @verifyaccount
  Scenario Outline: Opening new Account from the home page link
    Given Open Browser and launch the URL
    And User logged in by his credentials "<userName>", "<password>", "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<SSN>"
    When User clicks on Home link
    When User click on the Open New Account link on the home page
    And Create an account by entering the values "<accountType>"
    Then Message will be displayed as Your new account number: xxxxx capture the account number
    And Click on the Accounts Overview link and verify the created account number is displayed

    Examples: 
      | userName  | password | firstName | lastName | address    | city     | state         | zipCode | SSN       | accountType |
      | rohit12113 |   123456 | Rohit     | kumar    | Notenplien | Den Haag | south Holland | 2555ZZ  | 123456789 | SAVINGS     |
