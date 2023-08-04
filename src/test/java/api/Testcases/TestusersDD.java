package api.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.Endpoints.UserEndpoints;
import api.Utilites.Dataproviders;
import api.payloads.Users;
import io.restassured.response.Response;


public class TestusersDD {
	
	 Users userpayloaddata;
	@Test(priority=1,dataProvider = "data",dataProviderClass =Dataproviders.class)
	
	public void postusers(String userdata[]) 
	
	{
		userpayloaddata=new Users();
		
		userpayloaddata.setId(Integer.parseInt(userdata[0]));
		userpayloaddata.setUsername(userdata[1]);
		userpayloaddata.setFirstName(userdata[2]);
		userpayloaddata.setLastName(userdata[3]);
		userpayloaddata.setEmail(userdata[4]);
		userpayloaddata.setPassword(userdata[5]);
		userpayloaddata.setPhone(userdata[6]);
		
		Response ures=UserEndpoints.createusers(userpayloaddata);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
		
	}

	
	@Test(priority=2,dataProvider = "username",dataProviderClass =Dataproviders.class)
	
	public void Getusers(String uname) 
	{
		
		Response ures=UserEndpoints.getusers(uname);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
	}
	
	@Test(priority=3,dataProvider = "username",dataProviderClass =Dataproviders.class)
	public void putusers(String uname) 
	{
		userpayloaddata.setEmail("Test@wemail.com");
		userpayloaddata.setPassword("Test@123");
		userpayloaddata.setPhone("9651246832");
		
		Response ures=UserEndpoints.putusers(userpayloaddata, uname);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
		//to check the upadted 
		Response updres=UserEndpoints.getusers(uname);
		updres.then().log().all();
		
	}
	@Test(priority=4,dataProvider = "username",dataProviderClass =Dataproviders.class)
	
	public void Deleteusers(String uname) {
		Response ures=UserEndpoints.deleteusers(uname);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
	}
}
