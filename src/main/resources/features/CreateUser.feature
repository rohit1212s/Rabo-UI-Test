#Author: your.email@your.domain.com
Feature: Create User
  User creating new account

  @registration
  Scenario Outline: Create a user account by entering the values
    Given Open Browser and launch the URL
    When User click on Register button to create a new account
    And User enters data for all the required fields "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<phone>", "<SSN>", "<password>", "<confirm>"
    And User click on Register button under the registration form
    Then User should displayed the message Your account was created successfully. You are now logged in. "<loginConfirm>"
    And User should logout from the application
    Then User logged in by his credentials "<password>", "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<SSN>"

    Examples: 
      | firstName | lastName | address    | city     | state         | zipCode | phone      | SSN       | password | confirm | loginConfirm                                                  |
      | Rohit     | kumar    | Notenplien | Den Haag | south Holland | 2555ZZ  | 0684105405 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test1     | Test2    | Address1   | City1    | Stat1         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test2     | Test2    | Address2   | City2    | Stat2         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test3     | Test2    | Address3   | City3    | Stat3         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test4     | Test2    | Address4   | City4    | Stat4         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test5     | Test2    | Address5   | City5    | Stat5         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test6     | Test2    | Address6   | City6    | Stat6         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test7     | Test2    | Address7   | City7    | Stat7         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test8     | Test2    | Address8   | City8    | Stat8         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |
      | Test9     | Test2    | Address9   | City9    | Stat9         | 2555ZZ  | 1234567890 | 123456789 |   123456 |  123456 | Your account was created successfully. You are now logged in. |

  @homelink
  Scenario Outline: Writing the all links name present in the home page into the notepad
    Given Open Browser and launch the URL
    And User logged in by his credentials "<password>", "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<SSN>"
    When User clicks on Home link
    And User write all the name of links present in the notepad
    Then A new file should be created with name of alllinks.txt in the file folder

    Examples: 
      | password | firstName | lastName | address    | city     | state         | zipCode | SSN       |
      |   123456 | Rohit     | kumar    | Notenplien | Den Haag | south Holland | 2555ZZ  | 123456789 |
      |   123456 | Test1     | Test2    | Address1   | City1    | Stat1         | 2555ZZ  | 123456789 |
      |   123456 | Test2     | Test2    | Address2   | City2    | Stat2         | 2555ZZ  | 123456789 |
      |   123456 | Test3     | Test2    | Address3   | City3    | Stat3         | 2555ZZ  | 123456789 |
      |   123456 | Test4     | Test2    | Address4   | City4    | Stat4         | 2555ZZ  | 123456789 |
      |   123456 | Test5     | Test2    | Address5   | City5    | Stat5         | 2555ZZ  | 123456789 |
      |   123456 | Test6     | Test2    | Address6   | City6    | Stat6         | 2555ZZ  | 123456789 |
      |   123456 | Test7     | Test2    | Address7   | City7    | Stat7         | 2555ZZ  | 123456789 |
      |   123456 | Test8     | Test2    | Address8   | City8    | Stat8         | 2555ZZ  | 123456789 |
      |   123456 | Test9     | Test2    | Address8   | City9    | Stat9         | 2555ZZ  | 123456789 |

  @verifyaccount
  Scenario Outline: Opening new Account from the home page link
    Given Open Browser and launch the URL
    And User logged in by his credentials "<password>", "<firstName>", "<lastName>", "<address>", "<city>", "<state>", "<zipCode>", "<SSN>"
    When User clicks on Home link
    When User click on the Open New Account link on the home page
    And Create an account by entering the values "<accountType>"
    Then Message will be displayed as Your new account number: xxxxx capture the account number
    And Click on the Accounts Overview link and verify the created account number is displayed

    Examples: 
      | password | firstName | lastName | address    | city     | state         | zipCode | SSN       | accountType |
      |   123456 | Rohit     | kumar    | Notenplien | Den Haag | south Holland | 2555ZZ  | 123456789 | SAVINGS     |
      |   123456 | Test1     | Test2    | Address1   | City1    | Stat1         | 2555ZZ  | 123456789 | CHECKING    |
      |   123456 | Test2     | Test2    | Address2   | City2    | Stat2         | 2555ZZ  | 123456789 | SAVINGS     |
      |   123456 | Test3     | Test2    | Address3   | City3    | Stat3         | 2555ZZ  | 123456789 | CHECKING    |
      |   123456 | Test4     | Test2    | Address4   | City4    | Stat4         | 2555ZZ  | 123456789 | SAVINGS     |
      |   123456 | Test5     | Test2    | Address5   | City5    | Stat5         | 2555ZZ  | 123456789 | CHECKING    |
      |   123456 | Test6     | Test2    | Address6   | City6    | Stat6         | 2555ZZ  | 123456789 | SAVINGS     |
      |   123456 | Test7     | Test2    | Address7   | City7    | Stat7         | 2555ZZ  | 123456789 | CHECKING    |
      |   123456 | Test8     | Test2    | Address8   | City8    | Stat8         | 2555ZZ  | 123456789 | SAVINGS     |
      |   123456 | Test9     | Test2    | Address8   | City9    | Stat9         | 2555ZZ  | 123456789 | CHECKING    |
