package api.Endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payloads.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	
	public static ResourceBundle geturl()
	{
		
		ResourceBundle routes=ResourceBundle.getBundle("approutes");
		return routes;
		
	}

	public static Response createusers(Users payload) {
		
		String url=geturl().getString("user_post_url");

		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(url);
		return res;

	}
	
	public static Response getusers(String uname) {
		String url=geturl().getString("user_get_url");
		
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.get(url);		
		         return res;
		
	}
	
	public static Response putusers(Users payload,String uname)
	{
		String url=geturl().getString("user_update_url");
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
		String url=geturl().getString("user_delete_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.when()
				.delete(url);
		
		
		return res;
		
	}
}
