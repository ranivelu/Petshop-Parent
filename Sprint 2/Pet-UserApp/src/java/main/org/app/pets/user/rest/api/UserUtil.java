package org.app.pets.user.rest.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * All Utils & Constants (URI, String etc)
 * @author ravelu
 *
 */
public class UserUtil {
	
	public static final String SERVER_URI = "http://localhost:8080/petuser";

	public static final String REST_PRD_ID =  "/rest/product/";
	
	public static final String REST_C_ORDERS =  "/rest/order/create";
	
	public static final String REST_D_ORDERS =  "/rest/order/delete/";
	
	public static final String REST_C_USERS =  "/rest/user/create";
	
	public static final String REST_D_USERS =  "/rest/user/delete/";
	
	public static final String REST_U_USERS =  "/rest/user/update";
	
	public static final String REST_C_PRODUCT =  "/rest/product/create";
	
	public static final String REST_D_PRODUCT =  "/rest/product/delete/";
	
	//public static final String REST_U_PRODUCT =  "/rest/user/update";
	
	public static final String REST_C_CATEGORY =  "/rest/category/create";
	
	public static final String REST_D_CATEGORY =  "/rest/category/delete/";
	
	//public static final String REST_U_CATEGORY =  "/rest/user/update";
	
	
	public static String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
	}
	
}
