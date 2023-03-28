package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/hmdb";
        String user = "postgres";
        String password = "admin";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            ProductManager manager = new ProductManager(connection);

            
            Product productToUpdate = manager.find(2);
            if (productToUpdate == null) {
                System.out.println("Guncellenecek urun bulunamadi!");
                return;
            }

          
            productToUpdate.setProductName("Güncellenmiş Laptop");
            productToUpdate.setSalesPrice(3500.0);

            boolean success = manager.update(productToUpdate);
            if (success) {
                System.out.print("Urun basariyla guncellendi.");
            } else {
                System.out.print("Urun güncellenirken bir sorun oluştu.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
