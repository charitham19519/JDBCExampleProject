package com.sonata.OtherJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateExample {

	public static void main(String[] args) {
		int a=400;
		String b="HR";
		double c=2345.00;
		
		int x=540;
		String y="Admin";
		double z=3456.00;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/JDBCExample","root","admin@123");
			PreparedStatement ps=con.prepareStatement
					("insert into employee values(?,?,?)");
			ps.setInt(1, a);
			ps.setString(2, b);
			ps.setDouble(3, c);
			
			ps.addBatch();
			
			ps.setInt(1, x);
			ps.setString(2, y);
			ps.setDouble(3, z);
			
			ps.addBatch();
			ps.executeBatch();
			
		}catch(ClassNotFoundException e1) {System.out.println(e1);}
		catch(SQLException s1) {System.out.println(s1);}
	}

}
