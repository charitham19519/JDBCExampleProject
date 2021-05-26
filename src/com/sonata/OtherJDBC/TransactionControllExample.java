package com.sonata.OtherJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class TransactionControllExample {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/JDBCExample","root","admin@123");
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, 860);
			ps.setString(2, "sonata1");
			ps.setDouble(3, 2345.90);
			int a=ps.executeUpdate();
			con.commit();
			System.out.println("the number of records updated are "+a);
			
			
		}catch(ClassNotFoundException e1) {System.out.println(e1);}
		catch(SQLException e2) {
			e2.printStackTrace();
			con.rollback();
		}
		finally {
			con.close();
		}

	}

}
