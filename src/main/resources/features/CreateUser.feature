#Author: your.email@your.domain.com

Feature: Create User
  User creating new account
   @registration 
  Scenario Outline: Create a user account by entering the values
    Given Open Browser and launch the URL
    When User click on Register button to create a new account
    And User enters data for all the required fields "<First_Name>", "<Last_Name>", "<Address>", "<City>", "<State>", "<Zip_Code>", "<Phone>", "<SSN>", "<UserName>", "<Password>", "<Confirm>"
    And User click on Register button under the registration form
    Then User should displayed the message Your account was created successfully. You are now logged in.

    Examples: 
      | First_Name | Last_Name | Address    | City     | State         | Zip_Code | Phone      | SSN       | UserName  | Password | Confirm |
      | Rohit      | kumar     | Notenplien | Den Haag | south Holland | 2555ZZ   | 0684105405 | 123456789 | rohit1212 |   123456 |  123456 |

  @homelink 
  Scenario Outline: Writting the all links name present in the home page into the notepad
    Given Open Browser and launch the URL
    And User logged in by his credentials "<UserName>", "<Password>", "<First_Name>", "<Last_Name>", "<Address>", "<City>", "<State>", "<Zip_Code>", "<SSN>"
    When User clicks on Home link
    And User write all the name of links present in the notepad
    Then A new file should be created with name of alllinks.txt in the file folder

    Examples: 
      | UserName  | Password | First_Name | Last_Name | Address    | City     | State         | Zip_Code | SSN       |
      | rohit1212 |   123456 | Rohit      | kumar     | Notenplien | Den Haag | south Holland | 2555ZZ   | 123456789 |

  @verifyaccount
  Scenario Outline: Opening new Account from the home page link
    Given Open Browser and launch the URL
    And User logged in by his credentials "<UserName>", "<Password>", "<First_Name>", "<Last_Name>", "<Address>", "<City>", "<State>", "<Zip_Code>", "<SSN>"
    When User clicks on Home link
    When User click on the Open New Account link on the home page
    And Create an account by entering the values
    Then Message will be displayed as Your new account number: xxxxx capture the account number "your account"
    And Click on the Accounts Overview link and verify the created account number is displayed

    Examples: 
      | UserName  | Password | First_Name | Last_Name | Address    | City     | State         | Zip_Code | SSN       |
      | rohit1212 |   123456 | Rohit      | kumar     | Notenplien | Den Haag | south Holland | 2555ZZ   | 123456789 |
