package api.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints;
import api.payloads.Users;
import io.restassured.response.Response;

public class TestUsers {
	
	Faker fk;
	Users Userspayloaddata;
	
	@BeforeClass
	public void setupdata() {
		fk=new Faker();
		Userspayloaddata=new Users();
		
		Userspayloaddata.setId(fk.idNumber().hashCode());
		Userspayloaddata.setFirstName(fk.name().firstName());
		Userspayloaddata.setLastName(fk.name().lastName());
		Userspayloaddata.setUsername(fk.name().username());
		Userspayloaddata.setPhone(fk.phoneNumber().cellPhone());
		Userspayloaddata.setPassword(fk.internet().password(5,10));
		Userspayloaddata.setEmail(fk.internet().emailAddress());
		
	}
	@Test(priority=1)
	
	public void postusers() {
		
		Response ures=UserEndpoints.createusers(Userspayloaddata);
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void getusers() {
			
			Response ures=UserEndpoints.getusers(Userspayloaddata.getUsername());
			ures.then().log().all();
			Assert.assertEquals(ures.getStatusCode(), 200);
		}
	
	@Test(priority=3)
	
	public void putusers() {
		Userspayloaddata.setPhone(fk.phoneNumber().cellPhone());
		Userspayloaddata.setPassword(fk.internet().password(10, 15));
		Userspayloaddata.setEmail(fk.internet().emailAddress("@gmail.com"));
		
		Response ures=UserEndpoints.putusers(Userspayloaddata,Userspayloaddata.getUsername());
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
		
		//to  check the data updated
		Response updres=UserEndpoints.putusers(Userspayloaddata,Userspayloaddata.getUsername());
		updres.then().log().all();
		
		
		
		
	}
	
	@Test(priority=4)
	public void deleteusers()
	{
		Response ures=UserEndpoints.deleteusers(Userspayloaddata.getUsername());
		ures.then().log().all();
		Assert.assertEquals(ures.getStatusCode(), 200);
	}
	
	


}
