package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDelete {
	public static void main(String[] args) throws SQLException {
		   String url = "jdbc:postgresql://localhost/hmdb";
		   String user = "postgres";
		   String password = "admin";
	     
			Connection connection = DriverManager.getConnection(url,user,password);
			ProductManager manager = new ProductManager(connection);
			
			//Silmek istedigin Id
			long id = 0;
			try {
				manager.delete(id);
				System.out.print("Basariyla silindi: "+ id);
			} catch (Exception e) {
				System.out.print(e.getStackTrace());
			}
			
	}

}
