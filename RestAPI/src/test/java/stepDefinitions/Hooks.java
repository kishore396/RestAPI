package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		
		StepDefinition m=new StepDefinition();
		if(StepDefinition.place_id==null)
		{
		m.add_Place_Payload_with("nanda","puri","telugu");
		m.user_calls_with_http_request("AddPlaceApi","POST");
		m.verify_place_id_created_maps_to_using("nanda","GetPlaceApi");
		}
	}

}
