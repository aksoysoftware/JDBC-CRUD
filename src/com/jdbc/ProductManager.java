package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    
    private final Connection connection;
    
    public ProductManager(Connection connection) {
        this.connection = connection;
    }
    
    public boolean insert(Product product) {
        try {
            String query = "INSERT INTO Product (productName, salesPrice) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getSalesPrice());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                return false;
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    
    public boolean update(Product product) {
        try {
            String query = "UPDATE Product SET productName = ?, salesPrice = ? WHERE productId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getSalesPrice());
            statement.setLong(3, product.getId());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(long productId) {
        try {
            String query = "DELETE FROM Product WHERE productId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, productId);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Product find(long productId) {
        try {
            String query = "SELECT * FROM Product WHERE productId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("productId");
                String name = resultSet.getString("productName");
                double price = resultSet.getDouble("salesPrice");
                return new Product(id, name, price);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public List<Product> findAll() {
        try {
            String query = "SELECT * FROM Product";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("productId");
                String name = resultSet.getString("productName");
                double price = resultSet.getDouble("salesPrice");
                products.add(new Product(id, name, price));
            }
            return products;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}