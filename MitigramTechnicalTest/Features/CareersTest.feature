@Sanity
Feature: Test Careers Page
Scenario: Validate Submit with Personal Information

Given User Launch "Chrome"
When User Opens URL "http://www.mitigram.com" 
	Then Page Title should be "Welcome to Mitigram"
	And URL should be "https://www.mitigram.com/"
	And User click CAREERS Link 
	Then URL should be "https://www.mitigram.com/careers"
	When User Enters "FirstName" to firstName
	And User Enters "LastName" to lastName
	And User Enters "country" to country
	And User Enters his "email" to email
	And User Enters "phone" to phone
	And User click Select "Resume.pdf" pdf file 
	And user click Submit
	Then Verify the Career Page with "<Messages>"

Scenario Outline: Validate Submit with Personal Information

Given User Launch "Chrome"
When User Opens URL "http://www.mitigram.com" 
	Then Page Title should be "Welcome to Mitigram"
	And URL should be "https://www.mitigram.com/"
	And User click CAREERS Link 
	Then URL should be "https://www.mitigram.com/careers"
	When User Enters "<FirstName>" to firstName
	And User Enters "<LastName>" to lastName
	And User Enters "<country>" to country
	And User Enters his "<email>" to email
	And User Enters "<phone>" to phone
	And User click Select "Resume.pdf" pdf file 
	And user click Submit
	Then Verify the Career Page with "<Messages>"

	Examples:
 | FirstName | LastName | country  | email       | phone     | Messages                  |
 | Valid     | Valid    | Sweden   | Valid@a.com | 072980890 |         								  |
 |           | Valid    | Sweden   | Valid@a.com | 072980890 | First Name is required    |
 | Valid     |          | Sweden   | Valid@a.com | 072980890 | Last Name is required     |
 | Valid     | Valid    |          | Valid@a.com | 072980890 | Country  is required      |
 | Valid     | Valid    | Sweden   |             | 072980890 | A valid email is required |
 | Valid     | Valid    | Sweden   | Valid@a.com |           | Phone is required         |