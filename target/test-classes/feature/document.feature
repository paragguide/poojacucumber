Feature: Amazon Document
  I want to use this document to test amazon 

  @amazon @uid
  Scenario: Amazon Userid test
    Given I open "chrome" and get url "https://www.amazon.in/" create report "AmazonLogin"
    And click signin 
    When I enter valid userid "paragguide@yahoo.co.in"
    And click continue button
    Then I validate the userid 
    And check password textbox come
    
  @amazon @pwd  
  Scenario: Amazon Pasword test
   Given userid is valid and password txtbox displayed
   When i enter correct password "RMinfotech"
   Then i should login 
   
   @amazon @search
   Scenario Outline: Product Search
    Given i am logged in
    When i search product <product> in price range <price>
    Then search results must come
    
   Examples:
   | product | price |
   | Mobile | 15000 |
   | LCD | 45000 |
   | ipad | 52000 |

  
