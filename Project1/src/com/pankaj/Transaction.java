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
				connection.setAutoCommit(false);
				String amountDebitQuery = "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?";
				String amountCreditQuery = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";
                PreparedStatement dps = connection.prepareStatement(amountDebitQuery);
                PreparedStatement cps = connection.prepareStatement(amountCreditQuery);
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter your account number: ");
				int acc_no = sc.nextInt();
				System.out.println("Enter your amount : ");
				double amount = sc.nextDouble();
				dps.setDouble(1, amount);
				dps.setInt(2, acc_no);
				cps.setDouble(1, amount);
				cps.setInt(2,10002);
				dps.executeUpdate();
				cps.executeUpdate();
				if(isSufficient(connection, acc_no, amount)) {
					connection.commit();
					System.out.println("Transaction Succefull");
					
				}else{
					connection.rollback();
					System.out.println("Transaction failed because insufficient balance in your account!");
				}
				
			} catch (SQLException e) {
				// TODO: handle exception regards SQL 
				System.out.println(e.getMessage());
			}
		}
		static boolean isSufficient(Connection con,int acc_no, double amount) {
			try {
			String Query = "SELECT balance FROM accounts WHERE acc_no = ?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, acc_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				double curr_bal = rs.getDouble("balance");
				if(curr_bal>=amount)return true;
				
			  }
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return false;
		}
	     
	}


