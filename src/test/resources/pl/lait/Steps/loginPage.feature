Feature: Open main page and click on links

Scenario: Click in the all available buttons in main menu
Given I open main page
When I click on the "REGISTER" link
When I click on the "SUPPORT" link
When I click on the "CONTACT" link
When I click on the SIGN-ON link 
Then System is on SIGN-ON page

Scenario: Login to the newTours page
Given I open main page
When I click on the SIGN-ON link
And I login as "tutorial" with password "tutorial"
Then User is logged in