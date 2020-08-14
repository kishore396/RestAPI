package Resources;
 
//Enum is special class in java which has collection of constants or methods
public enum APIResources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	DeletePlaceApi("/maps/api/place/delete/json");
	private String resource;

	APIResources(String resource) 
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
