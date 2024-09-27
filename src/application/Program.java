package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST2: seller findByDepartment ===");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		
         System.out.println("\n=== TEST3: seller findAll ===");			
		 list = sellerDao.findAll();		
	    	for(Seller obj : list) {
			System.out.println(obj);
		}
	    	
	    	  System.out.println("\n=== TEST4: seller seller insert ===");	
	    	  Seller newSeller = new Seller(null,"Greg","Greg@gmail.com", new java.util.Date(), 4000.0, department);
	    	  sellerDao.insert(newSeller);
	    	  System.out.println("inserted!  New id = " + newSeller.getId()) ;
	    	  
	    	  
	    	  System.out.println("\n=== TEST5 update ===");	
	    	  seller = sellerDao.findById(1);
	    	  seller.setName("Marth Waine");
	    	  sellerDao.update(seller);
	    	  System.out.println("update completed");
	    	  

	}
	
	

}
