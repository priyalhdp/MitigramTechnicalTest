Feature:Login Tests
Scenario:Validate login button with login details
Given User Launch "Firefox"
	When User Opens URL "http://www.mitigram.com" 
	Then Page Title should be "Welcome to Mitigram"
	And URL should be "https://www.mitigram.com/"
	And User click LOGIN link
	Then URL should be "https://marketplace.mitigram.com/Account/Login?ReturnUrl=%2f"
	When User Enters "<email>" to email
	And User Enters "<Password>" to password
	And User click Login Button
	Then Verify the Portal with "<Messages>"
	

Scenario Outline:Validate login button with login details
Given User Launch "Firefox"
	When User Opens URL "http://www.mitigram.com" 
	Then Page Title should be "Welcome to Mitigram"
	And URL should be "https://www.mitigram.com/"
	And User click LOGIN link
	Then URL should be "https://marketplace.mitigram.com/Account/Login?ReturnUrl=%2f"
	When User Enters "<email>" to email
	And User Enters "<PassWord>" to password
	And User click Login Button
	Then Verify the Portal with "<Messages>"
	
Examples:
	| email    | PassWord | Messages 																			 |
	| Valid    | Valid    | Mitigram Portal                                |
	| Invalid  | Invalid  | The Email field is not a valid e-mail address. |
	| Valid    | Invalid  | Invalid login attempt.                         |
	| Invalid  | Valid    | Invalid login attempt.                         |
	|          |          | Email is required      												 |
	| Valid    |          | Password is required  										 	   |