package org.app.pets.user.rest.api;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.pet.service.model.Orders;
import org.app.pet.service.model.Product;
import org.app.pet.service.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Rest Client
 * @author ravelu
 *
 * Parses JSON Rest Api call to Objects.
 */
public class PetsUtil {
	
	Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Get Product By Id
	 * @param pCode
	 * @return
	 */
	public Product getProductById(long pCode) {

		Product prd = null;
		RestTemplate restTemplate = new RestTemplate();		 
		String urlPath = UserUtil.SERVER_URI + UserUtil.REST_PRD_ID + pCode;

		String prdJson = restTemplate.getForObject(urlPath , String.class);
		System.out.println(prdJson);
		 
		ObjectMapper objectMapper = new ObjectMapper();
	    
		try {
			prd = objectMapper.readValue(prdJson, Product.class);
			log.debug("Prd ID="+ prd.getPrdCode() +", Prd Name="+ prd.getPrdName() +", Prd Desc ="+ prd.getPrdDesc());
		} catch (JsonParseException e) {			
			e.printStackTrace();
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return prd;
	}
	
	/**
	 * Create User
	 * @param user
	 * @return
	 */
	public Users createUser(Users user) {
		
		RestTemplate restTemplate = new RestTemplate();		 
		String urlPath = UserUtil.SERVER_URI + UserUtil.REST_C_USERS;

		ResponseEntity<Users> userRes = restTemplate.postForEntity(urlPath , user, Users.class);
		System.out.println(userRes.getBody().getUsrAlias()+ " ; "+userRes.getBody().getUsrCode() );
		
		return userRes.getBody();
	}

	/**
	 * Create Order
	 * @param order
	 * @return
	 */
	public Orders createOrders(Orders order) {
		
		RestTemplate restTemplate = new RestTemplate();		 
		String urlPath = UserUtil.SERVER_URI + UserUtil.REST_C_ORDERS;

		ResponseEntity<Orders> ordRes = restTemplate.postForEntity(urlPath , order, Orders.class);
		System.out.println(ordRes.getBody().getOrdCode()+ " ; "+ordRes.getBody().getCreatedOn() );
		
		return ordRes.getBody();
	}
	

}
