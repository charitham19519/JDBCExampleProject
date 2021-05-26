package com.sonata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class UpdatePrepareExample {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCExample","root","admin@123");
			PreparedStatement ps=con.prepareStatement("update employee set empSal=? where empId=?");
			ps.setDouble(1, 6000.98);
			ps.setInt(2, 145);
			
			int a=ps.executeUpdate();
		}catch(ClassNotFoundException e1) {System.out.println(e1);}
		catch(SQLException e2) {System.out.println(e2);}

	}

}
