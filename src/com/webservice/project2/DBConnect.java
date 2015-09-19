package com.webservice.project2;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	public DBConnect(){
        String connectionString =
            "jdbc:sqlserver://your_server.database.windows.net:1433;" 
            + "database=your_database;"
            + "user=your_user@your_server;"
            + "password={your_password};"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;"; 

        String connectionString = "jdbc:mysql://bf580aaf83c045:f5a1139c@us-cdbr-azure-central-a.cloudapp.net/WebServices_ProjectTwo";
        
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement prepsInsertPerson = null;

        try {
            connection = DriverManager.getConnection(connectionString);

            // INSERT two rows into the table.
            // ...

            // TRANSACTION and commit for an UPDATE.
            // ...

            // SELECT rows from the table.
            // ...
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Close the connections after the data has been handled.
            if (prepsInsertPerson != null) try { prepsInsertPerson.close(); } catch(Exception e) {}
            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
    }
}
*/



//STEP 1. Import required packages
import java.sql.*;

public class DBConnect {
	
	static Connection connection;
	
	public DBConnect(){
		
		System.out.println("Loading driver...");

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		String url = "jdbc:mysql://localhost:3306/project2";
		String username = "root";
		String password = "";
	
		System.out.println("Connecting database...");
	
		try {
			connection = DriverManager.getConnection(url, username, password); 
		    System.out.println("Database connected!");
		
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	public static void selectCustomer(Connection con, Customer )
		    throws SQLException {

		    Statement stmt = null;
		    String query = "SELECT Customer_ID, customer_name FROM `Customer`";
		    
		    try {
		        stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            String cID = rs.getString("Customer_ID");
		            String cName = rs.getString("customer_name");
		            
		            System.out.println(cID + "\t" + cName);
		        }
		    } catch (SQLException e ) {
		       System.out.println(e.getMessage());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
	public static void main(String[] args) throws SQLException{
		DBConnect dbc = new DBConnect();
		DBConnect.selectCustomer(connection);
	}
	
}

