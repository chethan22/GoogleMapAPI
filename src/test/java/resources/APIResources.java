package resources;

public enum APIResources {
	
	AddplaceAPI("maps/api/place/add/json"),
	getPlaceApi("maps/api/place/get/json"),
	deletePlaceApi("maps/api/place/delete/json");
	private String resources;
	APIResources(String resources) {
		this.resources=resources;
	}
	
	public String getResources() {
		
		return resources;
	}
	
	
	

}
