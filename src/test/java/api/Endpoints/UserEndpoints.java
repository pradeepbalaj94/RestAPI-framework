package api.Endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createusers(Users payload) {

		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.user_PostURL);
		return res;

	}
	
	public static Response getusers(String uname) {
		
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.get(Routes.user_getURL);		
		         return res;
		
	}
	
	public static Response putusers(Users payload,String uname)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.body(payload)
				.when()
				.put(Routes.user_PutURL);
		
		
		return res;
		
		
	}
	
	public static Response deleteusers(String uname)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.delete(Routes.user_deleteURL);
		
		
		return res;
		
	}
}
