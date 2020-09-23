package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void BeforeSceanrio() throws IOException {

		StepDefination m = new StepDefination();
		if (StepDefination.place_Id == null) {
			
			m.add_place_payload_the("shetty", "kannada", "aldur");
			m.user_calls_with_http_request("AddplaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("shetty", "getPlaceApi");
		}

	}

}
