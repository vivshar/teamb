package com.vivshar.TeamB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOImpl {

	public int fun() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
			   "jdbc:postgres://vkpofcuxsisuio:02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009@ec2-50-17-217-166.compute-1.amazonaws.com:5432/ddq7urlrfunt2g","vkpofcuxsisuio", "02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009");
			
			if (connection != null) {
				Statement s = connection.createStatement();
				ResultSet rs = s.executeQuery("select * from employees order by last_name");
				return rs.getInt(1);
			} else {
				System.out.println("Failed to make connection!");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return 0;

		
		
	}
	
}
