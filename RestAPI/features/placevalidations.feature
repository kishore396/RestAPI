Feature: Validating Place API's 

	//Scenario: verify if Place is being successfully added using AddPlaceApi 
//	Given Add Place Payload 
//	When user calls "AddPlaceAPI" with "Post" http request 
//	Then the API call got success with status scode 200 
//  And "status" in response body is "OK" 
//	And "scope" in response body is "APP"

@AddPlace @Regression
Scenario Outline: verify if Place is being successfully added using AddPlaceApi 
	Given Add Place Payload with "<name>" "<address>" "<language>" 
	When user calls "AddPlaceApi" with "Post" http request 
	Then the API call got success with status scode 200 
	And "status" in response body is "OK" 
	And "scope" in response body is "APP" 
	And verify place_id created maps to "<name>" using "GetPlaceApi" 
	
	Examples:
	 
		| name           |       address                  |   language     |
		|Frontline       |     side layout, cohen 09      |   French       |
	#	|Frontline  house|     side layout, cohen 123     |   Spanish      |
		
@DeletePlace @Regression		
Scenario: verify if Delete Place functionality is working 
	Given DeletePlace Payload 
	When user calls "DeletePlaceApi" with "Post" http request 
	Then the API call got success with status scode 200 
	And "status" in response body is "OK" 
	
