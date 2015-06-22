package org.app.pet.service.json;

import org.app.pet.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Standalone Configuration
 * @author ravelu
 *
 */
@Configuration 
@EnableTransactionManagement
public class PetShopUtil {


	public static AnnotationConfigApplicationContext context = null;
	
	public PetShopUtil() {
		super();
		
		context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
	}

	public static AnnotationConfigApplicationContext getContext() {
		if(context == null) {
			context = new AnnotationConfigApplicationContext();
			context.register(AppConfig.class);
			context.refresh();
		}
		return context;
	}

	public static void setContext(AnnotationConfigApplicationContext context) {
		PetShopUtil.context = context;		
	}
	
	
}
