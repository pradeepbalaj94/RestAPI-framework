package api.Endpoints;

public class Routes {
	
	public static String baseurl="https://petstore.swagger.io/v2";
	
	//user module Endpoints
	
	public static String user_PostURL=baseurl+"/user";
	public static String user_getURL=baseurl+"/user/{username}";
	public static String user_PutURL=baseurl+"/user/{username}";
	public static String user_deleteURL=baseurl+"/user/{username}";

}
