Feature: Login to HRM Application 
  
   @ValidCredentials
   Scenario: Login with valid credentials
   	Given User is on Home page
    When User enters username as "Admin"
    And User enters password as "admin123"
    Then User should be able to login sucessfully
    
   Scenario: Login with Invalid credentials
    Given User is on Home page
    When User enters username as "Admin1111"
    And User enters password as "admin123"