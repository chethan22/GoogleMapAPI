package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_Id;

	TestDataBuild data = new TestDataBuild();

	@Given("Add place payload the {string} {string} {string}")
	public void add_place_payload_the(String name, String language, String address) throws IOException {

		res = given().spec(requestSpecfication()).body(data.addPlacePayLoad(name, language, address));
	}

	@When("user calls {string} with {string} HTTP request")
	public void user_calls_with_http_request(String resource, String method) {

		APIResources resourcesAPI = APIResources.valueOf(resource);
		System.out.println(resourcesAPI.getResources());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			response = res.when().post(resourcesAPI.getResources());
		else if (method.contentEquals("GET"))
			response = res.when().get(resourcesAPI.getResources());

	}

	@Then("the APi call got suscess with status code as {int}")
	public void the_a_pi_call_got_suscess_with_status_code_as(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExceptedValue) {

		assertEquals(getJsonPath(response, keyValue), ExceptedValue);
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExcpetedName, String resource) throws IOException {

		place_Id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecfication()).queryParam("place_id", place_Id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, ExcpetedName);

	}

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		res = given().spec(requestSpecfication()).body(data.deletePlacePayload(place_Id));

	}

}
