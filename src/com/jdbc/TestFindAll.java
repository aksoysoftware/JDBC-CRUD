package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestFindAll {
	public static void main(String[] args)throws SQLException {
		   String url = "jdbc:postgresql://localhost/hmdb";
		   String user = "postgres";
		   String password = "admin";
	     
			Connection connection = DriverManager.getConnection(url,user,password);
			ProductManager manager = new ProductManager(connection);
			
			
			   List<Product> products = new ArrayList<>();
			   
			try {
				products=manager.findAll();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				for (Product product : products) {
					System.out.println("Urun Bilgileri");
					System.out.println(product.getId());
					System.out.println(product.getProductName());
					System.out.println(product.getSalesPrice());
				}
			}
		
		
	}

}
