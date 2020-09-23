package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayLoad(String name, String language, String address) {

		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setName(name);
		p.setPhone_number("9535649774");
		List<String> mylist = new ArrayList<String>();
		mylist.add("pumma shoess");
		mylist.add("QAenginnerr");
		p.setTypes(mylist);
		Location l = new Location();
		l.setLat(50.87);
		l.setLng(60.85);
		p.setLocation(l);

		return p;

	}

	public String deletePlacePayload(String place_Id) {
		return "{\r\n" + "    \"place_id\":\""+place_Id+"\"\r\n" + "}\r\n" + "";
	}

}
