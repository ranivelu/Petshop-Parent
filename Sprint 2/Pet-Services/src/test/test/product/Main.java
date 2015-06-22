package test.product;

import java.util.List;

import org.app.pet.config.AppConfig;
import org.app.pet.service.dao.IAdminHistoryDao;
import org.app.pet.service.dao.ICategoryDao;
import org.app.pet.service.dao.IImageDao;
import org.app.pet.service.dao.IProductDao;
import org.app.pet.service.dao.IUsersDao;
import org.app.pet.service.json.PetShopUtil;
import org.app.pet.service.json.ProductService;
import org.app.pet.service.model.AdminHistory;
import org.app.pet.service.model.Category;
import org.app.pet.service.model.Image;
import org.app.pet.service.model.Product;
import org.app.pet.service.model.Users;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {

		ctx.register(AppConfig.class);
		ctx.refresh();
		
		IUsersDao idao = ctx.getBean(IUsersDao.class);

		Users usrList = idao.findByColumns(Users.COL_USR_ALIAS, "ravelu");
		System.out.println("" +usrList.getUsrName());
		usrList = idao.findById(Users.PK_COLUMN_NAME, 001);
		System.out.println("" +usrList.getUsrName());
		
		IUsersDao iusdao = PetShopUtil.getContext().getBean(IUsersDao.class);
		System.out.println("User" +iusdao);
		IAdminHistoryDao iAdminHistoryDao = PetShopUtil.getContext().getBean(IAdminHistoryDao.class);
		System.out.println("Admin Action" +iAdminHistoryDao);
		
		
		
		AdminHistory admList = iAdminHistoryDao.findById(AdminHistory.PK_COLUMN_NAME, 0);
		//System.out.println("Admin Action" +admList.getAdhAction());
		/*getProductList();
		getCategoriesList();
		getImageList();*/
		getUserList();
	}

	/**
	 * 
	 */
	public static void getProductList() {
		IProductDao pdao = ctx.getBean(IProductDao.class);

		final List<Object> prdList = pdao.findAll();
		System.out.println("Products :" + prdList.size());
		if (prdList != null) {
			for (Object obj : prdList) {
				Product prd = (Product) obj;
				System.out.println("Name:" + prd.getPrdName() + "-------Id:"
						+ prd.getPrdDesc());
			}
		}
	}
	
	/**
	 * 
	 */
	public static void getCategoriesList(){
		ICategoryDao cdao = ctx.getBean(ICategoryDao.class);

		final List<Object> catList = cdao.findAll();
		System.out.println("\nCategories :" + catList.size());
		if (catList != null) {
			for (Object obj : catList) {
				Category prd = (Category) obj;
				System.out.println("Name:" + prd.getCatName() + "-------Id:"
						+ prd.getCatDesc());
			}
		}
	}
	
	/**
	 * 
	 */
	public static void getImageList(){
		IImageDao idao = ctx.getBean(IImageDao.class);

		final List<Object> imgList = idao.findAll();
		System.out.println("\nImages :" + imgList.size());
		if (imgList != null) {
			for (Object obj : imgList) {
				Image img = (Image) obj;
				System.out.println("Name:" + img.getImgName() + "-------Id:"
						+ img.getImgDesc());
			}
		}
	}
	

	/**
	 * 
	 */
	public static void getUserList(){
		IUsersDao idao = ctx.getBean(IUsersDao.class);

		final List<Object> usrList = idao.findAll();
		System.out.println("\nImages :" + usrList.size());
		if (usrList != null) {
			for (Object obj : usrList) {
				Users usr = (Users) obj;
				System.out.println("Name:" + usr.usrAlias + "-------Id:"
						+ usr.getUsrCode());
			}
		}
	}
}