# RaboBankAssignment

This project is created against RaboBankAssignment to automate test cases to register a new user in the parabank site and create a new account.

Solutions

Project Structure:
This project is designed on Page Object Model approach with Cucumber Framework.

Page Objects Package-- It contains all the webelements and required methods to support the respective step definition file. 

Reusability methods:-
Utilities package- It contains a CommonActionclass which contains reusable methods to avoid duplicate lines of code.

src/main/resources-- It contains feature file and all the required properties file to run the project.
src/test/resources--
cucumber.option package-- it contains runner class which is required to run the project if user wants to run this project from JUnit. I have Created Runner test class with cucumber options to integrate with feature files ,step definition glued and cucumber JVM plugged in Debugged using Cucumber – JUnit Tests

stepdefination package-- It has hooks class to load the driver before running each scenario and stepdefinition file to suppport the respctive scenario in the feature file.

Driver folder-- It has all the drivers to support the multiple browser feature. User needs to provide value from the environment.properties file to run the project from different browser.

Target/cucumber-html-report--- It stores the detail level custom reporting after each execution run from the maven command--- mvn verify


Below steps to be follwed to see detail report:-
1. go to the project path in the command line 
2. run the command-- mvn verify
3. go to the folder>target>>cucumber-html-reports>> 
4. open the file overview-features.html from any browser and see the results.
