package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestFind {
	public static void main(String[] args) throws SQLException {
		   String url = "jdbc:postgresql://localhost/hmdb";
		   String user = "postgres";
		   String password = "admin";	
	
		    Connection connection = DriverManager.getConnection(url,user,password);
			ProductManager manager = new ProductManager(connection);
			
			
			Product product =new Product();
			Long Id=(long) 2;
			try {
				product=manager.find(Id);
				System.out.println("Urun Bilgileri");
				System.out.println(product.getId());
				System.out.println(product.getProductName());
				System.out.println(product.getSalesPrice());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

}
