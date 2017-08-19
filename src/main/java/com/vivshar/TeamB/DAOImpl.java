package com.vivshar.TeamB;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOImpl {

	public int fun() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection = null;
		ResultSet rs= null;
/*		try {
			connection = DriverManager.getConnection(
			   "jdbc:postgresql://ec2-50-17-217-166.compute-1.amazonaws.com:5432/ddq7urlrfunt2g","vkpofcuxsisuio", "02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009");
			
			
			URI dbUri = new URI("postgres://vkpofcuxsisuio:02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009@ec2-50-17-217-166.compute-1.amazonaws.com:5432/ddq7urlrfunt2g");

		    String username = dbUri.getUserInfo().split(":")[0];
		    String password = dbUri.getUserInfo().split(":")[1];
		    String dbUrl =  "jdbc:postgresql://ec2-50-17-217-166.compute-1.amazonaws.com:5432/ddq7urlrfunt2g?sslmode=require&user=vkpofcuxsisuio&password=02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009";  "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		    connection =  DriverManager.getConnection(dbUrl, "vkpofcuxsisuio", "02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009");
			
			
			
			if (connection != null) {
				Statement s = connection.createStatement();
				ResultSet rs = s.executeQuery("select * from employees order by last_name");
				return rs.getInt(1);
			} else {
				return -2;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		
		}*/
		
		try {
	        // ========>     from heroku website
			String url = "jdbc:postgresql://ec2-50-17-217-166.compute-1.amazonaws.com:5432/ddq7urlrfunt2g?user=vkpofcuxsisuio&password=02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	        Properties props = new Properties();
	        props.setProperty("user", "vkpofcuxsisuio");
	        props.setProperty("password", "02a43c5a4c1e333a2f24847cb75629d6ce8a0e05276a6ae98c246bd0af103009");
	        props.setProperty("ssl", "true");
	        connection = DriverManager.getConnection(url, props);
	        
	        if (connection != null) {
				Statement s = connection.createStatement();
				rs = s.executeQuery("select * from emp");
				rs.next();
				return rs.getInt(1);
			
	        	
			}
	        
	        
	    } catch (SQLException e) {

	        System.out.println("Connection Failed! Check output console");
	        e.printStackTrace();
	        return -2;
	    }
		
		
		
		
		finally {
			try {
				connection.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return -1;

		
		
	}
	
}
