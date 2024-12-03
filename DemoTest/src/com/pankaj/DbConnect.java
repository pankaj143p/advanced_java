package com.pankaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect {
     private static final String url = "jdbc:mysql://127.0.0.1:3306/combinedb";
     private static final String username = "root";
     private static final String password = "123@Code";
	 /**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// any exception found
			System.out.println(e.getMessage());
		}
		
		try {
	
			Connection connection = (Connection) DriverManager.getConnection(url,username, password);
//	        Statement statement = ((java.sql.Connection) connection).createStatement();	
			
//			<-- print only-->
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
			
			
			
//	        <-- for update -->
//	        String query = String.format("UPDATE teacher SET marks = %f WHERE id = %d" , 87.40,2);
			
//	        <-- for delete --> 
//	        String query = String.format("DELETE from teacher WHERE ID = 2");
//	        int row = statement.executeUpdate(query);
	        
	        
//	        <-------- CRUD operations using preparedStatement --------->
	        
//	        <-- for insert --> 
//	        String query = "INSERT INTO teacher(name, age, marks) VALUES(?, ?, ?)";
//	        PreparedStatement ps = ((java.sql.Connection) connection).prepareStatement(query);
//	        ps.setString(1, "Anshika");
//	        ps.setInt(2, 21);
//	        ps.setDouble(3, 93.45);
	        
	        
//	        <-- for select -->
//	        String query = "SELECT marks from teacher WHERE id = ?";	        
//	        PreparedStatement ps = ((java.sql.Connection) connection).prepareStatement(query);
//	        ps.setInt(1, 1);
//	        
//	        ResultSet rs = ps.executeQuery();
			
			
//			<-- for update --> 
//			String query = "UPDATE teacher SET marks = ? WHERE id = ?";	        
//	        PreparedStatement ps = ((java.sql.Connection) connection).prepareStatement(query);
//	        ps.setDouble(1, 98.80);
//	        ps.setInt(2, 3);
			
			
//			<-- for delete -->
//			String query = "DELETE from teacher WHERE id = ?";	        
//	        PreparedStatement ps = ((java.sql.Connection) connection).prepareStatement(query);
//	        ps.setDouble(1, 98.80);
//	        ps.setInt(1, 3);
	        
	        
			
//			< --- by using while loop and user input --->
			String query = "INSERT INTO teacher(name, age, marks) VALUES(?, ?, ?)";
			PreparedStatement ps = ((java.sql.Connection) connection).prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Enter your name: ");
				String name = sc.next();
				System.out.println("Enter your age: ");
				int age = sc.nextInt();
				System.out.println("Enter your marks: ");
                double marks = sc.nextDouble();
                String choice = sc.next();
                ps.setString(1, name);
                ps.setInt(2,age);
                ps.setDouble(3, marks);
                ps.addBatch();
                if(choice.toUpperCase().equals("N")) {
                	break;
                }
			}
			
			int arr[] = ps.executeBatch();
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0) {
					System.out.println("Query "+i+" is not executed successfully ");
				}
			}
			
			
//	        int rs = ps.executeUpdate();
//	        if(rs>0) {
//	        	System.out.println("Data Deleted Successfully");
//	        }else {
//	        	System.out.println("any error");
//	        }

			
		} catch (SQLException e) {
			// TODO: handle exception regards SQL 
			System.out.println(e.getMessage());
			
		}
	}
     
}
