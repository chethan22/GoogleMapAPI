Feature: Validating Place API's 

@AddPlace @Regression
Scenario Outline: Verify if placed is being Succesffuly added using AddPlaceAPI 
	Given Add place payload the "<name>" "<language>" "<address>" 
	When user calls "AddplaceAPI" with "POST" HTTP request 
	Then the APi call got suscess with status code as 200 
	And "status" in response body is "OK" 
	And verify place_id created maps to "<name>" using "getPlaceApi" 
	
	Examples: 
	
		|name            | language            | address    |
		|ChethanShettykpc|Kannada english      |kumbarahalli|
		#	|ChethanShetty257|Kannada english tamil|aldur       |
		
		@DeletePlace @Regression
		Scenario: verify if delete place Functionality is working 
		
			Given DeletePlace payload 
			When user calls "deletePlaceApi" with "POST" HTTP request 
			Then the APi call got suscess with status code as 200 
			And "status" in response body is "OK" 
			
    