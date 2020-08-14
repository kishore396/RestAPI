package stepDefinitions;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.Location;


public class StepDefinition extends Utils {
	  RequestSpecification res;
	  ResponseSpecification resspec;
	  Response response;
	  TestDataBuild databuild=new TestDataBuild();
	  static String place_id;

	  @Given("Add Place Payload with {string} {string} {string}")
	  public void add_Place_Payload_with(String name,String address,String language) throws IOException 
	{
		
			
			
		    
		  res= given().spec(requestSpecification()).body(databuild.addPlacePayload(name,address,language)); 
	    
	}

	  @When("user calls {string} with {string} http request")
	  public void user_calls_with_http_request(String resource, String method)
	{
		  //constructor will be called with valueof resource to pass
		  
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		 resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 if(method.equalsIgnoreCase("POST"))
		  response= res.when().post(resourceAPI.getResource());
		 
		 else if(method.equalsIgnoreCase("GET"))
		 response= res.when().get(resourceAPI.getResource());
	     //.then().spec(resspec).extract().response();
				   
	}

	@Then("the API call got success with status scode {int}")
	public void the_API_call_got_success_with_status_scode(Integer int1) {
	   assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
	 
	   assertEquals(getJsonPath(response,keyvalue),expectedvalue);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException 
	{
		
		 place_id=getJsonPath(response,"place_id");
		 res= given().spec(requestSpecification()).queryParam("place_id",place_id );
		 user_calls_with_http_request(resource,"GET");
		 String actualname=getJsonPath(response,"name");
		 assertEquals(actualname,expectedname);
	   
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException 
	{
		 res= given().spec(requestSpecification()).body(databuild.deletePlacePayload(place_id));
		 		
		 		
	}






}
