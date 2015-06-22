package org.app.pet.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.app.pet.service.dao.AdminHistoryDao;
import org.app.pet.service.dao.CategoryDao;
import org.app.pet.service.dao.IAdminHistoryDao;
import org.app.pet.service.dao.ICategoryDao;
import org.app.pet.service.dao.IImageDao;
import org.app.pet.service.dao.IOrderItemDao;
import org.app.pet.service.dao.IOrdersDao;
import org.app.pet.service.dao.IProductDao;
import org.app.pet.service.dao.IUsersDao;
import org.app.pet.service.dao.ImageDao;
import org.app.pet.service.dao.OrderItemDao;
import org.app.pet.service.dao.OrdersDao;
import org.app.pet.service.dao.ProductDao;
import org.app.pet.service.dao.UserDao;
import org.app.pet.service.model.AdminHistory;
import org.app.pet.service.model.Category;
import org.app.pet.service.model.Image;
import org.app.pet.service.model.OrderItem;
import org.app.pet.service.model.Orders;
import org.app.pet.service.model.Product;
import org.app.pet.service.model.Users;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
	
	
@Configuration 
@EnableTransactionManagement
public class AppConfig {  
	
	@Bean 
	public IAdminHistoryDao adminHistoryDao(){
		return new AdminHistoryDao();
	}
	
	@Bean  
    public ICategoryDao categoryDao() {  
        return new CategoryDao();  
    }	
	
	@Bean  
    public IImageDao imageDao() {  
        return new ImageDao();  
    }
	
	@Bean  
    public IOrderItemDao orderItemDao() {  
        return new OrderItemDao();  
    }
	
	@Bean  
    public IOrdersDao ordesDao() {  
        return new OrdersDao();  
    }

	@Bean  
    public IProductDao productDao() {  
        return new ProductDao();  
    }	
	
	@Bean 
	public IUsersDao userDao(){
		return new UserDao();
	}	
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}

	/**
	 * TBM: Moved to JPA
	 * @return
	 */
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClass(AdminHistory.class)				   
		   .addAnnotatedClass(Category.class)
		   .addAnnotatedClass(Image.class)
		   .addAnnotatedClass(OrderItem.class)
		   .addAnnotatedClass(Orders.class)
		   .addAnnotatedClass(Product.class)
		   .addAnnotatedClass(Users.class).buildSessionFactory();
	}
	
	/**
	 * TBD: Move to properties file
	 * @return
	 */
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
	    dataSource.setUrl("jdbc:derby://localhost:1527/petshopdb;create=true");
	    dataSource.setUsername("pet");
	    dataSource.setPassword("pet");
	 
	    return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}		
} 

