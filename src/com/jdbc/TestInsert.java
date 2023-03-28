package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestInsert {
	public static void main(String[] args) throws SQLException{
		   String url = "jdbc:postgresql://localhost/hmdb";
		   String user = "postgres";
		   String password = "admin";
	     
			Connection connection = DriverManager.getConnection(url,user,password);
			ProductManager manager = new ProductManager(connection);
			Product product = new Product("Silgi", 1.2);
			boolean s = manager.insert(product);
			if(s==true) {
					System.out.print("Urun basariyla eklendi.");
			}else {
				System.out.print("Urun eklenirken bir sorun olustu.");
			}
	

}
}