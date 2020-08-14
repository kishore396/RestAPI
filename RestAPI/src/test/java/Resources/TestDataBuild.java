package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.Location;

public class TestDataBuild {
	
	public Addplace addPlacePayload(String name,String address,String language)
	{
	  Addplace a=new Addplace();
		a.setAccuracy(50);
		a.setAddress(address);
		a.setLanguage(language);
		a.setName(name);
		a.setWebsite("http://google.com");
		a.setPhone_number("9955226644");
		
	   List<String> mylist=new ArrayList<String>(); 
		mylist.add("shoe park");
		mylist.add("shop");
		a.setTypes(mylist);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		return a;
	}
	
	public String deletePlacePayload(String placeid)
	{
		return "{\r\n" + 
		"    \r\n" + 
		"\"place_id\": \""+placeid+"\"\r\n" + 
		"\r\n" + 
		"}";
	}

}
