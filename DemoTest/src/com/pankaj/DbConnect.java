package com.pankaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
     private static final String url = "jdbc:mysql://127.0.0.1:3306/combinedb";
     private static final String username = "root";
     private static final String password = "123@Code";
	 public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// any exception found
			System.out.println(e.getMessage());
		}
		
		try {
	
			Connection connection = (Connection) DriverManager.getConnection(url,username, password);
	        Statement statement = ((java.sql.Connection) connection).createStatement();	
//	        for update 
//	        String query = String.format("UPDATE teacher SET marks = %f WHERE id = %d" , 87.40,2);
//	        for delete 
//	        String query = String.format("DELETE from teacher WHERE ID = 2");
//	        int row = statement.executeUpdate(query);
	        
	        
//	         CRUD operations using preparedStatement 
	        
	        String query = "INSERT INTO teacher(name, age, marks) VALUES(?, ?, ?)";
	        PreparedStatement ps = ((java.sql.Connection) connection).prepareStatement(query);
	        ps.setString(1, "Anshika");
	        ps.setInt(2, 21);
	        ps.setDouble(3, 93.45);
	        int row = ps.executeUpdate();
	        if(row>0) {
	        	System.out.println("delete successfully");
	        }else {
	        	System.out.println("any error");
	        }
//	        String query = "select * from teacher";
//	        ResultSet res = statement.executeQuery(query);
//	        while(res.next()) {
//	        	int id = res.getInt("id");
//	        	String name = res.getString("name");
//	        	int age = res.getInt("age");
//	        	double marks = res.getDouble("marks");
//	        	System.out.println("hey my id is "+id);
//	        	System.out.println("hey my name "+name);
//	        	System.out.println("hey my age "+age);
//	        	System.out.println("hey my is marks "+marks);
//	        }
			
		} catch (SQLException e) {
			// TODO: handle exception regards SQL 
			System.out.println(e.getMessage());
			
		}
	}
     
}
