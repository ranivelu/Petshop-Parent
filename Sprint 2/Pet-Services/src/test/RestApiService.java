import java.io.IOException;

import org.app.pet.service.model.Product;
import org.app.pet.service.model.Users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class RestApiService {
	
	public static String SERVER_URI = "http://localhost:8080/petuser";
    
    public static void main(String args[]){
         
        testProduct();
        System.out.println(" >> ");
        
        testCategories();
        System.out.println(" >> ");
        
        testUsers();
        System.out.println(" >> ");
        
    }
 
    private static void testUsers() {
    	
    	String REST_C_USERS =  "/rest/user/create";
    	
    	Users user = new Users();
    	user.setUsrAddress("PSN");
    	user.setUsrEmail("guest@pet.com");
    	user.setUsrMobile(00);
    	user.setUsrName("Guest");
    	user.setUsrAlias("guest");
    	user.setUsrPwd("guest");
    	user.setUsrType("C");
    	
    	
    	RestTemplate restTemplate = new RestTemplate();		 
		String urlPath = SERVER_URI + REST_C_USERS;

		ResponseEntity<Users> userRes = restTemplate.postForEntity(urlPath , user, Users.class);
		System.out.println(userRes.getBody().getUsrAlias()+ " ; "+userRes.getBody().getUsrCode() );
		
	}

	private static void testCategories() {
		// TODO Auto-generated method stub
		
	}

	private static void testProduct() {

		 RestTemplate restTemplate = new RestTemplate();
		 
		 //objectMapper.readValue(json, SearchRequest.class);
		 String url = SERVER_URI + "/rest/product/1";
		 
		String prdJson = restTemplate.getForObject(url, String.class);
		 System.out.println(prdJson);
		 
		ObjectMapper objectMapper = new ObjectMapper();
	    Product prd;
		try {
			prd = objectMapper.readValue(prdJson, Product.class);
			 System.out.println("Prd ID="+ prd.getPrdCode() +", Prd Name="+ prd.getPrdName() +", Prd Desc ="+ prd.getPrdDesc());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	         
	    //    System.out.println("Employee Object\n"+emp);
	     
	    
	}

	
 
   /* private static void testCreateEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = new Employee();
        emp.setId(1);emp.setName("Pankaj Kumar");
        Employee response = restTemplate.postForObject(SERVER_URI+EmpRestURIConstants.CREATE_EMP, emp, Employee.class);
        printEmpData(response);
    }*/
 
   
}