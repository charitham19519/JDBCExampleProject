package com.sonata.OtherJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateCallableExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/JDBCExample","root","admin@123");
			CallableStatement cs=con.prepareCall("{call UPDATEPRO2(?,?)}");
			cs.setInt(2, 860);
			cs.setString(1, "xx");
//			cs.setDouble(3, 3456.0);
			
			int rs=cs.executeUpdate();
			System.out.println("the number of records inserted is "+rs);
		}catch(ClassNotFoundException e1) {System.out.println(e1);}
		catch(SQLException e2) {
			e2.printStackTrace();
		}

	}

}
