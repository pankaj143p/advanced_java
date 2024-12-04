package com.pankaj;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class Transaction {
	     private static final String url = "jdbc:mysql://127.0.0.1:3306/banktransaction";
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
				String amountDebitQuery = "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?";
				String amountCreditQuery = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";
                PreparedStatement dps = connection.prepareStatement(amountDebitQuery);
                PreparedStatement cps = connection.prepareStatement(amountCreditQuery);
				Scanner sc = new Scanner(System.in);
				double amount = sc.nextDouble();
				dps.setDouble(1, amount);
				dps.setInt(2, 10003);
				cps.setDouble(1, amount);
				cps.setInt(2,10001);
				
				dps.executeUpdate();
				cps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO: handle exception regards SQL 
				System.out.println(e.getMessage());
				
			}
		}
	     
	}


