package com.sonata;

import java.sql.DriverManager;
import java.sql.*;


public class InsertPrepareExample {

	public static void main(String[] args) {
	  try {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection
				  ("jdbc:mysql://localhost:3306/JDBCExample","root","admin@123");
		  
		  PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
		  ps.setInt(1, 145);
		  ps.setString(2, "TATA");
		  ps.setDouble(3,5000);
		  int a=ps.executeUpdate();
		  System.out.println("the number of records update are "+a);
		  
	  }catch(ClassNotFoundException e1) {
		  System.out.println(e1);
	  }
	  catch(SQLException e2) {
		  System.out.println(e2);
	  }

	}

}
