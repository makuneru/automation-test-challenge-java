Feature: Automation Test Challenge

	@test-challenge
  Scenario: Account Creation and Login, New Account Opening, and Transaction Search
  #UI Test Scenarios
    Given User navigates to Registration Page
    When User enters the details into Registration Page
    And User clicks on Register button
    Then User account should get created successfully and logged in
    Then User click on logout button
    
    Given User navigates to login page
    When User enters valid username into "" username field
    And User enters valid password into "" password field
    And User clicks on Login button
    Then User should get successfully logged in
    
    Given User navigates to Open New Account Page
    When User selects "SAVINGS" in type of account to open
    And User clicks on Open New Account button
    Then User new savings account should get created successfully
    And User clicks on the new account id link
		Then User validates the new account details
	
    Given User navigates to Find Transactions Page
    When User selects the new account
    And User enter the amount in Find By Amount Field
    And User clicks on Find Transactions by "AMOUNT" button
    Then User should see the transaction results.

	#API Test Scenarios
    Given Rest service login endpoint "/services/bank/login/"
    When User Call "GET" method.
    Then User validates response is successful with code "200"
    And User validates the user details response schema
    
    Given Rest service customer details endpoint "/services/bank/customers/"
    When User Call "GET" method. 
    Then User validates response is successful with code "200"
    And User validates the user details response schema
    
    Given Rest service create account endpoint "/services/bank/createAccount" 
		When User Call POST method with account "SAVINGS" parameters.
    Then User validates response is successful with code "200"
    Then User validates "SAVINGS" account created.
    And User validates the create account response schema
    
    Given Rest service find transactions endpoint "/services/bank/accounts//transactions/amount/" by amount "100"
		When User Call "GET" method.
    Then User validates response is successful with code "200"
    Then User validates transaction results with details
    | type   | amount | description             |
    | Credit | 100    | Funds Transfer Received |
    And User validates the find transactions response schema
    